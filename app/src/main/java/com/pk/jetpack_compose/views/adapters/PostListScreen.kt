package com.pk.jetpack_compose.views.adapters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pk.jetpack_compose.data.model.Post

@Composable
fun PostListScreen(posts: List<Post>) {
    LazyColumn(modifier = Modifier.padding(all = 10.dp)) {
        items(posts) { post ->
            PostItem(post = post)
        }
    }
}

@Composable
fun PostItem(post: Post) {
    Card(
        modifier = Modifier
            .padding(all = 15.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )

    ) {
        Column(modifier = Modifier.padding(all = 10.dp)) {
            Text(
                text = post.title,
                style = TextStyle(color = Color.Black),
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = post.id.toString(),
                modifier = Modifier.padding(10.dp),
                style = TextStyle(color = Color.Red, fontSize = 16.sp)
            )

        }
    }
}
