import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {
    val countDownFlow = flow<Int> {
        val init = 10
        var current = init
        emit(current)
        while (current > 0) {
            delay(1000)
            current--
            emit(current)

        }
    }

    init {
        collectFlow()
    }

    private fun collectFlow() {
        viewModelScope.launch {
            // launch 會在當前的協程中啟動一個新的協程 裡面的執行是有序的

            countDownFlow.collect {
                println(" im listen $it ")
            }
            countDownFlow.collectLatest {
                // 如果在事件接收之前有新的事件觸發澤前一個事件會被拋棄
                delay(1500)
                println("should not show $it")
            }

        }
    }
}