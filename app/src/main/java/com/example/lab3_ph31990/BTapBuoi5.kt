package com.example.lab3_ph31990


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.internal.ViewUtils.RelativePadding


class BTapBuoi5 : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xff252121),
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        GetTextTitle("Thanh toán")
                    }
                )
            },
        ) { innerPadding ->
            GetLayout(innerPadding)
        }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GetLayout(innerPadding: PaddingValues = PaddingValues()){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(
                top = innerPadding.calculateTopPadding()
            )
            .background(Color(0xFF262121))
            .padding(5.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
//        GetTextTitle("Thanh Toán")
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Địa chỉ nhận hàng ",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF262121))
                .padding(5.dp),
            textAlign = TextAlign.Left
        )

        RowDiaChiNhanHang()

        Text(
            text = "Vui lòng chọn một trong những phương thức sau: ",
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF262121))
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Left
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF262121))
                .padding(0.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ThanhToan("PayPal", R.drawable.paypal,Color(0xFFfa8500))
            ThanhToan("Visa", R.drawable.visa,Color(0xFF0e4494))
            ThanhToan("Momo", R.drawable.momo,Color(0xFFec1387))
            ThanhToan("Zalo Pay", R.drawable.zalopay,Color(0xFF00c2fd))
            ThanhToan("Thanh toán trực tiếp", R.drawable.thanhtoantt,Color(0xFF18ebea))
        }


        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color(0xFFfe734c)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Tiếp theo", color = Color.White)
        }
        Spacer(modifier = Modifier.weight(1f))
        BottomNavigationBar()
    }
}

@Composable
fun RowDiaChiNhanHang(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF262121))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.vitri),
            contentDescription = null,
            modifier = Modifier.size(40.dp)

        )
        DiaChiNhanHang()
    }
}
@Composable
fun ThanhToan(name: String, logo: Int,bg:Color){
    Row(
        modifier = Modifier
            .padding(5.dp)
            .background(bg, shape = RoundedCornerShape(15.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = logo),
            modifier = Modifier
                .size(56.dp)
                .padding(4.dp),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = name,color = Color.White, modifier = Modifier.weight(1f))

        RadioButton(selected = false, onClick = {})
    }
}

@Composable
fun GetTextTitle(title: String){
    Text(
        text = title,
        fontSize = 25.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(0.dp, 16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun DiaChiNhanHang() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF262121))
            .padding(5.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Tri | 222222", color = Color.White)
        Text(text = "22/333 đường Trung Mỹ Tây 1", color = Color.White)
        Text(text = "phường Tân Thới Nhất", color = Color.White)
        Text(text = "quận 12, Thành phố Hồ Chí Minh", color = Color.White)
    }


}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color(0xFF312c2c),
        contentColor = Color.White
    ) {
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_home), contentDescription = null) },
            label = {
                Text(
                    text = "Trang chủ",
                    style = TextStyle(color = Color.White)
                )
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_calendar), contentDescription = null) },
            label = {
                Text(
                    text = "Lịch sử",
                    style = TextStyle(color = Color.White)
                )
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_bag_24), contentDescription = null) },
            label = {
                Text(
                    text = "Giỏ hàng",
                    style = TextStyle(color = Color.White)
                )
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = { Icon(painter = painterResource(id = R.drawable.ic_person_outline), contentDescription = null) },
            label = {
                Text(
                    text = " Hồ Sơ ",
                    style = TextStyle(color = Color.White)
                )
            },
            selected = false,
            onClick = {}
        )
    }
}