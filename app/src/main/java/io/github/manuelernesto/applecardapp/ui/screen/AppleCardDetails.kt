package io.github.manuelernesto.applecardapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.manuelernesto.applecardapp.R
import io.github.manuelernesto.applecardapp.ui.composables.CircleBar
import io.github.manuelernesto.applecardapp.ui.theme.Dark
import io.github.manuelernesto.applecardapp.ui.theme.White
import io.github.manuelernesto.applecardapp.ui.theme.WhiteBg

/*Card Detail Starts here*/

@Composable
fun MyTopBarDetail() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Cancel", fontWeight = FontWeight.Bold, color = Dark)
        Row {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Dark)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_more),
                    contentDescription = "more Icon",
                    tint = White
                )
            }

        }
    }
}

@Composable
fun CardDetail() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBg)
            .padding(16.dp)
    ) {
        MyTopBarDetail()
        CircleBar()
    }
}
/*Card Detail  Ends here*/