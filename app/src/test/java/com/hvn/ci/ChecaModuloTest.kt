package com.hvn.ci

import org.junit.experimental.categories.Category
import org.junit.jupiter.api.Test

@Category(ChecaModuloTest:: class)
class ChecaModuloTest : KoinTest{

    @Test
    fun checaModulos() = checkModules{
        modules()
    }
}