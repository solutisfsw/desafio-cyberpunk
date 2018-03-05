package com.example.mnmat.cyberpunk

import com.example.mnmat.cyberpunk.models.Clone
import android.support.design.widget.CoordinatorLayout.Behavior.setTag
import android.R.attr.name
import android.view.ViewGroup
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.getDescription
import android.support.v4.app.NotificationCompat.getCategory
import android.R.attr.description
import android.app.Activity
import android.content.ClipData.Item
import android.content.Context
import android.content.Intent
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.*


/**
 * Created by mnmat on 02/03/2018.
 */
public class ClonesListAdapter : ArrayAdapter<Clone> {

        constructor(context: Context, textViewResourceId: Int) : super(context, textViewResourceId) {}

        constructor(context: Context, resource: Int, items: List<Clone>) : super(context, resource, items) {}

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {

            var v = convertView

            if (v == null) {
                val vi: LayoutInflater
                vi = LayoutInflater.from(context)
                v = vi.inflate(R.layout.item_clone, null)
            }

            val p = getItem(position)

            if (p != null) {
                val tt1 = v!!.findViewById(R.id.item_desc) as TextView
                val tt2 = v.findViewById(R.id.item_det) as Button
                val tt3 = v.findViewById(R.id.item_del) as ImageButton

                tt1?.setText("${p.nome} (${p.idade})");

                tt2?.setOnClickListener {
                    val intent = Intent(context, Details::class.java);
                    intent.putExtra(Details.CLONE_STR, p)
                    (context as Activity).startActivityForResult(intent, MainActivity.REQUEST_EDITAR);
                }

                tt3?.setOnClickListener { if(context is MainActivity) {
                    (context as MainActivity).remove_clone(p.id!!)
                } }
            }

            return v
        }

}