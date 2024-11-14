package com.example.muhammad_irfan_musthofa

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Product(
    val name: String,
    val category: String,
    val price: Double,
    val image: Int,
    val description: String
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(product: Product) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = product.name) },
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.back),
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6200EA)
                )
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = product.name,
                    modifier = Modifier
                        .size(200.dp)
                        .padding(16.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = product.name,
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 4.dp)
                )

                Text(
                    text = product.category,
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Text(
                    text = "$${product.price}",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 24.sp, fontWeight = FontWeight.SemiBold),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewProductDetailScreen() {
    val sampleProduct = Product(
        name = "Handphone",
        category = "Elektronik",
        price = 599.99,
        image = R.drawable.phone,
        description = "Sebuah Hp Mahal Banget Brooo, jangan Coba Coba Beli Kalo Gaada Dana Karna Hape Ini DiTargetkan Untuk Orang Organ berduit sahaja hahaha"
    )
    ProductDetailScreen(product = sampleProduct)
}
