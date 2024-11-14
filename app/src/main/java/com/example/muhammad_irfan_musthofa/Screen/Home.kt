//package com.example.muhammad_irfan_musthofa
//
//import android.R.drawable.ic_menu_myplaces
//import android.R.drawable.ic_menu_search
//import android.R.drawable.ic_menu_view
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.lazy.grid.items
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MainScreen() {
//    val navController = rememberNavController()
//    Scaffold(
//        topBar = { MyTopBar(navController) },
//        bottomBar = { CustomBottomBar(navController) }
//    ) { paddingValues ->
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(paddingValues)
//        ) {
//            NavigationGraph(navController)
//        }
//    }
//}
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MyTopBar(navController: NavHostController) {
//    val currentRoute = navController.currentBackStackEntry?.destination?.route
//    var title by remember { mutableStateOf("Irfan Musthofa") }
//
//    LaunchedEffect(currentRoute) {
//        title = when (currentRoute) {
//            "home" -> "Home"
//            "market" -> "Market"
//            "profile" -> "Profile"
//            else -> "Irfan Musthofa"
//        }
//    }
//
//    TopAppBar(
//        title = {
//            Text(
//                text = title,
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.White
//            )
//        },
//        navigationIcon = {
//            IconButton(onClick = { }) {
//                Icon(
//                    painter = painterResource(id = android.R.drawable.ic_menu_view),
//                    contentDescription = "Menu",
//                    tint = Color.White
//                )
//            }
//        },
//        colors = TopAppBarDefaults.topAppBarColors(
//            containerColor = Color(0xFF6200EA)
//        )
//    )
//}
//
//
//
//
//@Composable
//fun CustomBottomBar(navController: NavHostController) {
//    var selectedIndex by remember { mutableStateOf(0) }
//    val items = listOf(
//        BottomBarItem("home", ic_menu_view, "home"),
//        BottomBarItem("search", ic_menu_search, "market"),
//        BottomBarItem("profile", ic_menu_myplaces, "profile")
//    )
//
//    NavigationBar(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(60.dp)
//            .padding(horizontal = 16.dp)
//            .background(Color(0xFF6200EA), RoundedCornerShape(30.dp)),
//        containerColor = Color.Transparent,
//        contentColor = Color.White
//    ) {
//        items.forEachIndexed { index, item ->
//            NavigationBarItem(
//                icon = {
//                    Icon(
//                        painter = painterResource(id = item.iconRes),
//                        contentDescription = item.label
//                    )
//                },
//                label = {
//                    Text(
//                        text = item.label,
//                        fontSize = 12.sp,
//                        fontWeight = if (index == selectedIndex) FontWeight.Bold else FontWeight.Normal
//                    )
//                },
//                selected = selectedIndex == index,
//                onClick = {
//                    selectedIndex = index
//                    navController.navigate(item.route) {
//                        popUpTo(navController.graph.startDestinationId)
//                        launchSingleTop = true
//                    }
//                },
//                colors = NavigationBarItemDefaults.colors(
//                    selectedIconColor = Color.Black,
//                    selectedTextColor = Color.Black,
//                    unselectedIconColor = Color.White,
//                    unselectedTextColor = Color.White
//                )
//            )
//        }
//    }
//}
//
//@Composable
//fun NavigationGraph(navController: NavHostController) {
//    NavHost(navController, startDestination = "home") {
//        composable("home") { HomeScreen() }
//        composable("market") { MarketScreen() }
//        composable("profile") { ProfileScreen() }
//    }
//}
//
//@Composable
//fun HomeScreen() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.LightGray)
//            .padding(16.dp)
//    ) {
//        Text(
//            text = "Explore Categories",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//        val categories = listOf("Elektrik", "Style", "Dekorasi Rumah", "Buku", "Kecantikan")
//        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//            items(categories) { category -> CategoryItem(category) }
//        }
//        Spacer(modifier = Modifier.height(16.dp))
//        Text(
//            text = "Featured Products",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//        val products = listOf(
//            Product("Handphone", "Elektrik", 599.99, R.drawable.phone, R.drawable.phone),
//            Product("Sepatu", "Style", 79.99, R.drawable.sepatu, R.drawable.phone),
//            Product("Sofa", "Dekor Rumah", 299.99, R.drawable.sofa, R.drawable.phone),
//            Product("Earth Phone", "Elektrik", 99.99, R.drawable.headphone, R.drawable.phone),
//            Product("Buku", "Buku", 24.99, R.drawable.book, R.drawable.phone),
//            Product("Serum", "Kecantikan", 599.99, R.drawable.serum, R.drawable.phone),
//            Product("Meja Kecil", "Fashion", 79.99, R.drawable.meja, R.drawable.phone),
//            Product("Pot", "Dekor Rumah", 299.99, R.drawable.pot, R.drawable.phone),
//            Product("SkinCare", "Kecantikan", 99.99, R.drawable.skincare, R.drawable.phone),
//            Product("Baju", "Style", 24.99, R.drawable.baju, R.drawable.phone)
//        )
//        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
//            items(products) { product -> ProductItem(product) }
//        }
//    }
//}
//
//@Composable
//fun MarketScreen() {
//    var searchQuery by remember { mutableStateOf("") }
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.LightGray)
//            .padding(16.dp)
//    ) {
//        // Search bar
//        SearchBar(searchQuery = searchQuery, onSearchQueryChanged = { searchQuery = it })
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Title
//        Text("Market", fontSize = 24.sp, fontWeight = FontWeight.Bold)
//        Spacer(modifier = Modifier.height(8.dp))
//
//        // Product list
//        val products = listOf(
//            Product("Handphone", "Elektrik", 599.99, R.drawable.phone, R.drawable.phone),
//            Product("Sepatu", "Style", 79.99, R.drawable.sepatu, R.drawable.phone),
//            Product("Sepatu", "Style", 79.99, R.drawable.sepatu, R.drawable.phone),
//            Product("Sofa", "Dekor Rumah", 299.99, R.drawable.sofa, R.drawable.phone),
//            Product("Earth Phone", "Elektrik", 99.99, R.drawable.headphone, R.drawable.phone),
//            Product("Buku", "Buku", 24.99, R.drawable.book, R.drawable.phone),
//            Product("Serum", "Kecantikan", 599.99, R.drawable.serum, R.drawable.phone),
//            Product("Meja Kecil", "Fashion", 79.99, R.drawable.meja, R.drawable.phone),
//            Product("Pot", "Dekor Rumah", 299.99, R.drawable.pot, R.drawable.phone),
//            Product("SkinCare", "Kecantikan", 99.99, R.drawable.skincare, R.drawable.phone),
//            Product("Baju", "Style", 24.99, R.drawable.baju, R.drawable.phone),
//            Product("Handphone", "Elektrik", 599.99, R.drawable.phone, R.drawable.phone),
//            Product("Sepatu", "Style", 79.99, R.drawable.sepatu, R.drawable.phone),
//            Product("Sepatu", "Style", 79.99, R.drawable.sepatu, R.drawable.phone),
//            Product("Sofa", "Dekor Rumah", 299.99, R.drawable.sofa, R.drawable.phone),
//            Product("Earth Phone", "Elektrik", 99.99, R.drawable.headphone, R.drawable.phone),
//            Product("Buku", "Buku", 24.99, R.drawable.book, R.drawable.phone),
//            Product("Serum", "Kecantikan", 599.99, R.drawable.serum, R.drawable.phone),
//            Product("Meja Kecil", "Fashion", 79.99, R.drawable.meja, R.drawable.phone),
//            Product("Pot", "Dekor Rumah", 299.99, R.drawable.pot, R.drawable.phone),
//            Product("SkinCare", "Kecantikan", 99.99, R.drawable.skincare, R.drawable.phone),
//            Product("Baju", "Style", 24.99, R.drawable.baju, R.drawable.phone),
//            Product("Handphone", "Elektrik", 599.99, R.drawable.phone, R.drawable.phone),
//            Product("Sepatu", "Style", 79.99, R.drawable.sepatu, R.drawable.phone),
//            Product("Sepatu", "Style", 79.99, R.drawable.sepatu, R.drawable.phone),
//            Product("Sofa", "Dekor Rumah", 299.99, R.drawable.sofa, R.drawable.phone),
//            Product("Earth Phone", "Elektrik", 99.99, R.drawable.headphone, R.drawable.phone),
//            Product("Buku", "Buku", 24.99, R.drawable.book, R.drawable.phone),
//            Product("Serum", "Kecantikan", 599.99, R.drawable.serum, R.drawable.phone),
//            Product("Meja Kecil", "Fashion", 79.99, R.drawable.meja, R.drawable.phone),
//            Product("Pot", "Dekor Rumah", 299.99, R.drawable.pot, R.drawable.phone),
//            Product("SkinCare", "Kecantikan", 99.99, R.drawable.skincare, R.drawable.phone),
//            Product("Baju", "Style", 24.99, R.drawable.baju, R.drawable.phone)
//        )
//
//        // LazyVerticalGrid for displaying products in a grid layout
//        LazyVerticalGrid(
//            columns = GridCells.Adaptive(minSize = 150.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp),
//            horizontalArrangement = Arrangement.spacedBy(12.dp),
//            modifier = Modifier.fillMaxSize()
//        ) {
//            items(products.filter {
//                it.name.contains(searchQuery, ignoreCase = true) || it.category.contains(searchQuery, ignoreCase = true)
//            }) { product ->
//                ProductItem(product)
//            }
//        }
//    }
//}
//
//@Composable
//fun CategoryItem(category: String) {
//    Box(
//        modifier = Modifier
//            .background(Color(0xFF6200EA), shape = RoundedCornerShape(16.dp))
//            .padding(horizontal = 20.dp, vertical = 10.dp)
//    ) {
//        Text(text = category, color = Color.White, fontWeight = FontWeight.Medium)
//    }
//}
//
//@Composable
//fun ProductItem(product: Product) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(100.dp),
//        shape = RoundedCornerShape(16.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(8.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Image(
//                painter = painterResource(id = product.imageRes),
//                contentDescription = product.name,
//                modifier = Modifier.size(64.dp)
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            Column {
//                Text(text = product.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
//                Text(text = product.category, fontSize = 14.sp, color = Color.Gray)
//                Text(text = "$${product.price}", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
//            }
//        }
//    }
//}
//
//@Composable
//fun SearchBar(searchQuery: String, onSearchQueryChanged: (String) -> Unit) {
//    TextField(
//        value = searchQuery,
//        onValueChange = onSearchQueryChanged,
//        placeholder = { Text("Search...") },
//        modifier = Modifier.fillMaxWidth()
//    )
//}
//
//data class BottomBarItem(val label: String, val iconRes: Int, val route: String)
//
//@Composable
//fun ProfileScreen() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        // Profile Image
//        Card(
//            shape = CircleShape,
//            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//            modifier = Modifier.size(120.dp)
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.profile),
//                contentDescription = "Profile Picture",
//                modifier = Modifier
//                    .size(120.dp)
//                    .background(Color.Gray)
//            )
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Profile Information
//        Text(
//            text = "Muhammad Irfan Musthofa",
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.Black
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Text(
//            text = "mirvanmusthofa@gmail.com",
//            fontSize = 16.sp,
//            color = Color.Gray
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // University and Major
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            Text(
//                text = "Politeknik Negeri Batam",
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Medium,
//                color = Color.Black
//            )
//            Text(
//                text = "|",
//                fontSize = 16.sp,
//                color = Color.Gray
//            )
//            Text(
//                text = "Teknik Informatika",
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Medium,
//                color = Color.Black
//            )
//        }
//    }
//}
////@Preview(showBackground = true)
////@Composable
////fun PreviewMainScreen() {
////    MainScreen()
////}
