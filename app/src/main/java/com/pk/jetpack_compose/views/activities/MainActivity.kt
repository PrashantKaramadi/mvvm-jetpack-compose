package com.pk.jetpack_compose.views.activities

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.pk.jetpack_compose.data.model.Post
import com.pk.jetpack_compose.views.adapters.PostListScreen
import com.pk.jetpack_compose.views.viewmodels.PostViewModel
import com.pk.jetpack_compose.views.viewmodels.PostViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var postViewModel: PostViewModel
    private lateinit var postViewModelFactory: PostViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        postViewModelFactory = PostViewModelFactory()
        postViewModel = ViewModelProvider(this, postViewModelFactory)[PostViewModel::class.java]

        setContent {
            MaterialTheme(
                colorScheme = lightColorScheme(
                    primary = Color(0xFF6200EE), // Purple500
                    secondary = Color(0xFF03DAC5) // Teal200
                )
            ) {
                Surface(
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PostScreenUI()
                }
            }
        }
    }

    @Composable
    fun PostScreenUI() {
        val postList = postViewModel.post.observeAsState(emptyList()).value
        PostListScreen(posts = postList)
    }
}