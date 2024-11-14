//package com.example.muhammad_irfan_musthofa.Screen
//
//import android.R.drawable.ic_menu_myplaces
//import android.R.drawable.ic_menu_search
//import android.R.drawable.ic_menu_view
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Icon
//import androidx.compose.material3.NavigationBar
//import androidx.compose.material3.NavigationBarItem
//import androidx.compose.material3.NavigationBarItemDefaults
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableIntStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.muhammad_irfan_musthofa.Componen.HomeScreen
//
//@Composable
//fun BottomBar() {
//    val navController = rememberNavController()
//    Scaffold(
//        bottomBar = {
//            CustomBottomBar(navController)
//        }
//    ) { innerPadding ->
//        Box(modifier = Modifier
//            .background(Color.LightGray)
//            .padding(innerPadding)) {
//            NavigationGraph(navController)
//        }
//    }
//}
//
//
//@Composable
//fun CustomBottomBar(navController: NavHostController) {
//    var selectedIndex by remember { mutableIntStateOf(0) }
//    val items = listOf(
//        BottomBarItem("Home", ic_menu_view, "home"),
//        BottomBarItem("Search", ic_menu_search, "search"),
//        BottomBarItem("Profile", ic_menu_myplaces, "profile")
//    )
//
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(60.dp)
//            .padding(horizontal = 16.dp)
//            .background(Color(0xFF6200EA), RoundedCornerShape(30.dp))
//    ) {
//        NavigationBar(
//            modifier = Modifier.fillMaxWidth(),
//            containerColor = Color.Transparent,
//            contentColor = Color.White
//        ) {
//            items.forEachIndexed { index, item ->
//                NavigationBarItem(
//                    icon = {
//                        Icon(
//                            painter = painterResource(id = item.iconRes),
//                            contentDescription = item.label
//                        )
//                    },
//                    label = {
//                        Text(
//                            text = item.label,
//                            fontSize = 12.sp,
//                            fontWeight = if (index == selectedIndex) FontWeight.Bold else FontWeight.Normal
//                        )
//                    },
//                    selected = selectedIndex == index,
//                    onClick = {
//                        selectedIndex = index
//                        navController.navigate(item.route) {
//                            popUpTo(navController.graph.startDestinationId)
//                            launchSingleTop = true
//                        }
//                    },
//                    colors = NavigationBarItemDefaults.colors(
//                        selectedIconColor = Color.Black,
//                        selectedTextColor = Color.Black,
//                        unselectedIconColor = Color.White,
//                        unselectedTextColor = Color.White
//                    )
//                )
//            }
//        }
//    }
//}
//
//data class BottomBarItem(val label: String, val iconRes: Int, val route: String)
//
//@Composable
//fun NavigationGraph(navController: NavHostController) {
//    NavHost(navController, startDestination = "home") {
//        composable("home") { HomeScreen() }
//        composable("search") { MarketScreen() }
//        composable("profile") {}
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewMainScreen() {
//    BottomBar()
//}
