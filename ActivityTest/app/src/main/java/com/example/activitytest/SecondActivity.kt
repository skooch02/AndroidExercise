package com.example.activitytest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.second_layout.*

class SecondActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SecondActivity", "Task id is $taskId")
        setContentView(R.layout.second_layout)
        button2.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SecondActivity", "onDestroy")
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("data_return", "Hello FirstActivity")
        setResult(RESULT_OK, intent)
        finish()
    }

    companion object {
        fun actionStart(context: Context, data1: String, data2: String) {
            val intent = Intent(context, SecondActivity::class.java).apply {
                putExtra("param1", data1)
                putExtra("param2", data2)
            }
            context.startActivity(intent)
        }
    }
}