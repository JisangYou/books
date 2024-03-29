package com.example.rxkotlin.observerAndObservable

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class ObserverSample {

    val observer: Observer<Any> = object : Observer<Any> {

        override fun onSubscribe(d: Disposable) {
            println("Subscribed to $d")
        }

        override fun onNext(item: Any) {
            println("Next $item")
        }

        override fun onComplete() {
            println("All Completed")
        }

        override fun onError(e: Throwable) {
            println("Error Occured $e")
        }
    }

}