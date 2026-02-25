
package com.example.olimpicfantasy.data

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.auth.Auth


object SupabaseHelper {

    val client = createSupabaseClient(
        supabaseUrl = "https://ytsvsujlchrwgrmdzeua.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Inl0c3ZzdWpsY2hyd2dybWR6ZXVhIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NzIwMDQwNDIsImV4cCI6MjA4NzU4MDA0Mn0.NLUa36i_OKn95bulSpL5fKMpH0xlezMIBrN9A7wN870"
    ) {
        install(Auth)
    }
}
