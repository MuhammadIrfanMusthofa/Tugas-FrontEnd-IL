import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.material3.icons.Icons
//import androidx.compose.material3.icons.filled.Home
//import androidx.compose.material3.icons.filled.ShoppingCart
//import androidx.compose.material3.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.muhammad_irfan_musthofa.BottomBarItem
import com.example.muhammad_irfan_musthofa.HomeScreen
import com.example.muhammad_irfan_musthofa.MarketScreen
import com.example.muhammad_irfan_musthofa.Product
import com.example.muhammad_irfan_musthofa.ProductItem
import com.example.muhammad_irfan_musthofa.R
import com.example.muhammad_irfan_musthofa.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Irfan Musthofa",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_view),
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_search),
                    contentDescription = "Search",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF6200EA)
        )
    )
}

@Composable
fun CustomBottomBar(navController: NavHostController) {
    var selectedIndex by remember { mutableStateOf(0) }
    val items = listOf(
        BottomBarItem("Home", R.drawable.home, "home"), // Mengganti dengan ikon dari drawable
        BottomBarItem("Search", R.drawable.cart, "market"), // Mengganti dengan ikon dari drawable
        BottomBarItem("Profile", R.drawable.user, "profile") // Mengganti dengan ikon dari drawable
    )

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 16.dp)
            .background(Color(0xFF6200EA), RoundedCornerShape(30.dp)),
        containerColor = Color.Transparent,
        contentColor = Color.White
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconRes), // Memastikan ini adalah ID yang valid
                        contentDescription = item.label
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        fontSize = 12.sp,
                        fontWeight = if (index == selectedIndex) FontWeight.Bold else FontWeight.Normal
                    )
                },
                selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    selectedTextColor = Color.Black,
                    unselectedIconColor = Color.White,
                    unselectedTextColor = Color.White
                )
            )
        }
    }
}


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        composable("market") { MarketScreen() }
        composable("profile") {  }
    }
}

@Composable
fun MarketScreen() {

    Column(modifier = Modifier.fillMaxSize()) {
        // Top Bar
        MyTopBar()

        Spacer(modifier = Modifier.padding(6.dp))

        var searchQuery by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .weight(1f)  // Takes up the remaining vertical space
                .background(Color.LightGray)
                .padding(16.dp)
        ) {
            // Search bar
            SearchBar(
                searchQuery = searchQuery,
                onSearchQueryChanged = { query -> searchQuery = query }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Title
            Text(
                text = "Market",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Lazy Grid for Products
            val products = listOf(
                Product("Handphone", "Elektrik", 599.99, R.drawable.phone, R.drawable.phone),
                Product("Sepatu", "Style", 79.99, R.drawable.sepatu, R.drawable.phone),
                Product("Sofa", "Dekor Rumah", 299.99, R.drawable.sofa, R.drawable.phone),
                Product("Earth Phone", "Elektrik", 99.99, R.drawable.headphone, R.drawable.phone),
                Product("Buku", "Buku", 24.99, R.drawable.book, R.drawable.phone),
                Product("Serum", "Kecantikan", 599.99, R.drawable.serum, R.drawable.phone),
                Product("Meja Kecil", "Fashion", 79.99, R.drawable.meja, R.drawable.phone),
                Product("Pot", "Dekor Rumah", 299.99, R.drawable.pot, R.drawable.phone),
                Product("SkinCare", "Kecantikan", 99.99, R.drawable.skincare, R.drawable.phone),
                Product("Baju", "Style", 24.99, R.drawable.baju, R.drawable.phone)
            )

            val filteredProducts = products.filter {
                it.name.contains(searchQuery, ignoreCase = true) || it.category.contains(searchQuery, ignoreCase = true)
            }

            // LazyVerticalGrid for displaying products
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 150.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(filteredProducts) { product ->
                    ProductItem(product)
                }
            }
        }

        // Bottom Bar
//        BottomBar()
    }
}
