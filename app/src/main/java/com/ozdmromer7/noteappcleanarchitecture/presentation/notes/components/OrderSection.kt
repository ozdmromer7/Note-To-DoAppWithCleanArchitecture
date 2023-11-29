package com.ozdmromer7.noteappcleanarchitecture.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ozdmromer7.noteappcleanarchitecture.R.string
import com.ozdmromer7.noteappcleanarchitecture.domain.util.NoteOrder
import com.ozdmromer7.noteappcleanarchitecture.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit

) {

    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            RadioButtonComponent(
                text = stringResource(string.title),
                isSelected = noteOrder is NoteOrder.Title,
                onSelected = { onOrderChange(NoteOrder.Title(noteOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(width = 8.dp))

            RadioButtonComponent(
                text = stringResource(id = string.date),
                isSelected = noteOrder is NoteOrder.Date,
                onSelected = { onOrderChange(NoteOrder.Date(noteOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(width = 8.dp))

            RadioButtonComponent(
                text = stringResource(id = string.color),
                isSelected = noteOrder is NoteOrder.Color,
                onSelected = { onOrderChange(NoteOrder.Color(noteOrder.orderType)) }
            )

        }
        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier=Modifier.fillMaxWidth()) {

            RadioButtonComponent(
                text = stringResource(id = string.ascending),
                isSelected = noteOrder is NoteOrder.Title,
                onSelected = { onOrderChange(noteOrder.copy(orderType = OrderType.Ascending)) }
            )
            Spacer(modifier = Modifier.width(width = 8.dp))

            RadioButtonComponent(
                text = stringResource(id = string.descending),
                isSelected = noteOrder is NoteOrder.Date,
                onSelected = { onOrderChange(noteOrder.copy(orderType = OrderType.Descending)) }
            )

        }
    }

}