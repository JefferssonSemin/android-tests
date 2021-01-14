package data.remote

import domain.entities.Usuario
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("users/{nome}")
    suspend fun buscaUsuario(@Path("nome") nome: String): Response<Usuario>
}