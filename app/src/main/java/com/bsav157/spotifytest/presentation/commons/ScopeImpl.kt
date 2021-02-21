package com.bsav157.spotifytest.presentation.commons

abstract class ScopeImpl : Scope by Scope.Impl() {

    init {
        initScope()
    }

    fun destroy() {
        destroyScope()
    }
}