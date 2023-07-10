package com.example.nogle.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nogle.common.NetworkResult
import com.example.nogle.data.api.BtseRepository
import com.example.nogle.model.CoinIndexDetail
import com.example.nogle.model.Market
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val btseRepository: BtseRepository
) : ViewModel() {

    private var _marketLivedata = MutableLiveData<List<Market>>()
    val marketLivedata: LiveData<List<Market>> = _marketLivedata

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private var _isShowError = MutableLiveData<Boolean>()
    val isShowError: LiveData<Boolean> = _isShowError

    private val _socketStatus = MutableLiveData(false)
    val socketStatus: LiveData<Boolean> = _socketStatus

    private val _coinIndexLiveData = MutableLiveData<Map<String, CoinIndexDetail>>()
    val coinIndexLiveData: LiveData<Map<String, CoinIndexDetail>> = _coinIndexLiveData

    private val _futureLiveData: MediatorLiveData<List<Market>> =
        MediatorLiveData<List<Market>>().apply {
            addSource(_marketLivedata) {
                postValue(it)
            }
            addSource(_coinIndexLiveData) { it ->
                val result = marketLivedata.value?.map { market ->
                    val tempMarket = market.copy()
                    val found = it.values.find { it.id == tempMarket.symbol }
                    if (found != null) {
                        tempMarket.copy(openInterest = found.price)
                    }
                    tempMarket
                }
                postValue(result)
            }
        }

    val futureLiveData: LiveData<List<Market>>
        get() = _futureLiveData

    fun addMessage(data: Map<String, CoinIndexDetail>) = viewModelScope.launch(Dispatchers.Main) {
        if (_socketStatus.value == true) {
            // filter type 1
            val filteredData = data.filter { it.value.type == 1 }
            _coinIndexLiveData.postValue(filteredData)
        }
    }

    fun setStatus(status: Boolean) = viewModelScope.launch(Dispatchers.Main) {
        _socketStatus.value = status
    }

    fun getMarketList() {
        viewModelScope.launch {
            btseRepository.getMarkets().collect { response ->
                when (response) {
                    is NetworkResult.Success -> {
                        _marketLivedata.postValue(response.data ?: listOf())
                        _isLoading.postValue(false)
                    }

                    is NetworkResult.Error -> {
                        _isShowError.postValue(true)
                    }

                    is NetworkResult.Loading -> {
                        _isLoading.postValue(true)
                    }
                }
            }
        }
    }
}