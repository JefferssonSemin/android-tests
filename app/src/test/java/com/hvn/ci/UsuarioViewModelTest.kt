package com.hvn.ci

import com.hvn.ci.domain.entities.Usuario
import com.hvn.ci.ui.UsuarioViewModel
import com.hvn.ci.util.TodoTestRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.internal.runners.statements.ExpectException
import org.junit.rules.ExpectedException

class UsuarioViewModelTest {

    @get:Rule
    val expectException: ExpectedException = ExpectedException.none()

    // private lateinit var usuarioRepository: UserRepository

    @Before
    fun setup() {
        val usuariosLista = ArrayList<Usuario>()
        var usuario = Usuario("Jeffersson", "asd", "teste", "teste", "teste")
        usuariosLista.add(usuario)
        usuario = Usuario("Jeffersson", "asd", "teste", "teste", "teste")
        usuariosLista.add(usuario)
        usuario = Usuario("Jeffersson", "asd", "teste", "teste", "teste")
        usuariosLista.add(usuario)
        usuario = Usuario("Jeffersson", "asd", "teste", "teste", "teste")
        usuariosLista.add(usuario)

//        usuarioRepository = TodoTestRepository(usuariosLista)
    }

//    @Test
//    fun test_todosUsuarios() {
//        val esperado = 4
//        val model = UsuarioViewModel(usuarioRepository)
//
//        val todos = model.buscaTodos().value
//
//        assertNotNull(model)
//        assertEquals(esperado, todos!!.size)
//    }
//
//    @Test
//    fun test_toggleTo() {
//        val model = UsuarioViewModel(usuarioRepository)
//        expectException.expect(NotImplementedError::class.java)
//
//        model.buscaTodos()
//    }
}