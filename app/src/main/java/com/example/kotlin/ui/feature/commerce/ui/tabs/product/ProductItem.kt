package com.example.kotlin.ui.feature.commerce.ui.tabs.product

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin.R
import com.example.kotlin.ui.feature.network.models.response.product.ProductItemDto

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    product: ProductItemDto? = null,
    onFavClick: () -> Unit = {},
    onAddClick: () -> Unit = {}
) {
    val colorScheme = MaterialTheme.colorScheme

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, colorScheme.tertiary),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        ProductCoverSection(
            colorScheme = colorScheme,
            onFavClick = onFavClick,
            imageCover = R.drawable.ads
        )

        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Nike Air Jordon",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorScheme.onPrimary
                )
            )
            Text(
                text = "Nike shoes flexible for women",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = colorScheme.onPrimary
                )
            )

            PriceSection(
                price = "EGP 1,200",
                oldPrice = "2000 EGP",
                colorScheme = colorScheme
            )

            RatingSection(
                rating = "4.6",
                colorScheme = colorScheme,
                onAddClick = onAddClick
            )
        }
    }
}

@Composable
fun PriceSection(
    price: String,
    oldPrice: String,
    colorScheme: ColorScheme,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = price,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = colorScheme.onPrimary
            )
        )
        Text(
            text = oldPrice,
            style = TextStyle(
                fontSize = 11.sp,
                textDecoration = TextDecoration.LineThrough,
                color = Color.Gray
            )
        )
    }
}

@Composable
fun RatingSection(
    rating: String,
    colorScheme: ColorScheme,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Review ($rating) ",
                style = TextStyle(fontSize = 12.sp, color = colorScheme.onPrimary)
            )
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "rating",
                tint = Color(0xFFFFC107),
                modifier = Modifier.size(16.dp)
            )
        }
        IconButton(
            onClick = onAddClick,
            modifier = Modifier
                .padding(start = 8.dp)
                .size(32.dp)
                .clip(CircleShape)
                .background(colorScheme.primary)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "add to cart",
                tint = Color.White,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Composable
fun ProductCoverSection(
    modifier: Modifier = Modifier,
    colorScheme: ColorScheme,
    onFavClick: () -> Unit,
    @DrawableRes imageCover : Int
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(imageCover),
            contentDescription = "product image",
            modifier = Modifier
                .fillMaxWidth()
                .height(128.dp),
            contentScale = ContentScale.Crop
        )
        IconButton(
            onClick = onFavClick,
            modifier = Modifier.padding(6.dp)
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "favorite",
                tint = colorScheme.primary,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(8.dp)
            )
        }
    }
}