package com.mursitaffandi.rfci

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), TextUndoRedo.TextChangeInfo {
    override fun textAction() {
        canUndo = undoRedo.canUndo()
        canRedo = undoRedo.canRedo()
    }

    private lateinit var undoRedo: TextUndoRedo
    private var canRedo = false
    private var canUndo = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        undoRedo = TextUndoRedo(findViewById(R.id.et_input), this)
        textAction()


        var i = 0
        bt_undo_redo.setOnClickListener {
            i++
            val handler = Handler()
            val r = Runnable {
                i = 0
            }

            if (i == 1) {
                //Single click
                if (canUndo) undoRedo.exeUndo()
                handler.postDelayed(r, 350)
            } else if (i == 2) {
                //Double click
                if (canRedo) undoRedo.exeRedo()
                i = 0
            }
        }


        bt_reverse.setOnClickListener {

            tv_output.text = "Output: " + textRevert(et_input.text.toString())

        }
    }

    private fun textRevert(text: String): String {
        if (text.isEmpty()) return text
        val arrayCharInput: MutableList<Char> = mutableListOf()
        for (n in 0 until text.length)
            arrayCharInput.add(text[n])


        val arrayCharReversed: MutableList<Char> = mutableListOf()
        for (i in arrayCharInput.size - 1 downTo 0)
            arrayCharReversed.add(arrayCharInput[i])
        var ret = ""
        for (j in arrayCharReversed.iterator())
            ret += j.toString()
        return ret
    }

}
