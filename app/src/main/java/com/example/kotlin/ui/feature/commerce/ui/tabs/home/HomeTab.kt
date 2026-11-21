package com.example.kotlin.ui.feature.commerce.ui.tabs.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kotlin.R
import com.example.kotlin.ui.component.CustomTextField
import com.example.kotlin.ui.feature.commerce.domain.entities.common.CategoryItem
import com.example.kotlin.ui.feature.commerce.domain.utility.Resource
import com.example.kotlin.ui.feature.commerce.ui.common.MainErrorSection
import com.example.kotlin.ui.feature.commerce.ui.common.MainLoadingSection
import com.example.kotlin.ui.feature.commerce.ui.tabs.home.composable.AdsSection
import com.example.kotlin.ui.feature.commerce.ui.tabs.home.composable.MainSectionLayout
import dagger.hilt.android.lifecycle.HiltViewModel


@Composable
fun SearchTextLayout(
    modifier: Modifier = Modifier,
    value: String,
    onChange: (String) -> Unit,
    hintText: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CustomTextField(
            value = value,
            hintText = hintText,
            onChange = onChange,
            modifier = Modifier.weight(1f),
            leadingIcon = {
                Image(
                    painter = painterResource(R.drawable.search),
                    contentDescription = "search icon",
                    modifier = Modifier.size(24.dp)
                )
            }
        )
        Image(
            painter = painterResource(R.drawable.cart),
            contentDescription = "cart icon",
            modifier = Modifier.size(32.dp)
        )
    }
}
//


@Composable
fun HomeTab(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val colorScheme = MaterialTheme.colorScheme
    var query by remember { mutableStateOf("") }
val state by viewModel.state.collectAsStateWithLifecycle()
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Image(
                painter = painterResource(R.drawable.route_blue),
                contentDescription = "Route logo",
                modifier = Modifier.size(width = 90.dp, height = 40.dp)
            )
        }
        item {



            SearchTextLayout(
                value = query,
                onChange = { query = it },
                hintText = "what do you search for?"
            )
        }
        item { AdsSection() }
        item { MainSectionLayout(text = "Categories", viewAll = "view all") }
        item {
            when (val categories = state.categoryState) {
                is Resource.Initial-> MainLoadingSection()
                is Resource.Loading -> MainLoadingSection()

                is Resource.Success<List<CategoryItem>> -> HomeSuccessSection(
                    colorScheme = colorScheme,
                    categoriesList = categories.data
                )

                is Resource.Error -> MainErrorSection(
                    modifier = Modifier.height(260.dp),
                    errorMessage = categories.errorMessage,
                    onTryAgain = { viewModel.loadCategory() }
                )

                else -> {}
            }
        }
    }
}