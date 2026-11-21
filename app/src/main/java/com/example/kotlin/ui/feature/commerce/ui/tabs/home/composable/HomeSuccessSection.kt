//
//package com.example.kotlin.ui.feature.commerce.ui.tabs.home
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
//import androidx.compose.foundation.lazy.grid.items
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.ColorScheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.kotlin.R
//import com.example.kotlin.ui.feature.commerce.domain.entities.common.CategoryItem
//
//// List<CategoryItem> => index
//@Composable
//fun HomeSuccessSection(
//    modifier: Modifier = Modifier,
//    colorScheme: ColorScheme,
//    categoriesList: List<CategoryItem>
//) {
//    LazyHorizontalGrid(
//        rows = GridCells.Fixed(2),
//        modifier = modifier.height(260.dp),
//        horizontalArrangement = Arrangement.spacedBy(12.dp),
//        verticalArrangement = Arrangement.spacedBy(12.dp)
//    ) {
//        items(categoriesList) { category ->
//            ItemLayout(
//                category = category,
//                colorScheme = colorScheme
//            )
//        }
//    }
//}
//
//// CategoryItem => name, image
//@Composable
//fun ItemLayout(
//    modifier: Modifier = Modifier,
//    category: CategoryItem,
//    colorScheme: ColorScheme
//) {
//    Column(
//        modifier = modifier,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Image(
//            painter = painterResource(R.drawable.ads), // مؤقتاً، هنبدلها بـ AsyncImage
//            contentDescription = category.name,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .size(80.dp)
//                .clip(CircleShape)
//        )
//        Text(
//            text = category.name ?: "",
//            maxLines = 2,
//            textAlign = TextAlign.Center,
//            overflow = TextOverflow.Ellipsis,
//            style = TextStyle(
//                fontWeight = FontWeight.Normal,
//                color = colorScheme.onPrimary,
//                fontSize = 14.sp
//            )
//        )
//    }
//}

package com.example.kotlin.ui.feature.commerce.ui.tabs.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.kotlin.R
import com.example.kotlin.ui.feature.commerce.domain.entities.common.CategoryItem

@Composable
fun HomeSuccessSection(
    modifier: Modifier = Modifier,
    colorScheme: ColorScheme,
    categoriesList: List<CategoryItem>
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = modifier.height(260.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(categoriesList) { category ->
            ItemLayout(
                category = category,
                colorScheme = colorScheme
            )
        }
    }
}

@Composable
fun ItemLayout(
    modifier: Modifier = Modifier,
    category: CategoryItem,
    colorScheme: ColorScheme
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = category.image?:"",
            contentDescription = category.name,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.ads),
            error = painterResource(R.drawable.ads),
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Text(
            text = category.name ?: "",
            maxLines = 2,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                color = colorScheme.onPrimary,
                fontSize = 14.sp
            )
        )
    }
}