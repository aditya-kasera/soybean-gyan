package com.example.soybeangyan.ui.read.activities


import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soybeangyan.R
import com.example.soybeangyan.ui.read.adapters.TableAdapter
import com.example.soybeangyan.ui.read.dataclasses.TableData

class TableActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
//        setTheme(R.style.Theme_SoybeanGyan)
        val childTitle = intent.getStringExtra("childTitle")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = childTitle

        recyclerView = findViewById(R.id.recycler_view)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TableAdapter(this, getList())
        recyclerView.adapter = adapter
    }

    private fun getList(): List<TableData> {
        val tableList = mutableListOf<TableData>()
        tableList.add(TableData("1.", "PPI", "Fluchloralin 45EC\n\nTrifluralin 48EC\n\n\n\n\nMetalochlor 50EC\n\nChlomozone 50EC", "Basalin\n\n\nTreflan, Trinetra, Tufan, Flora\n\nDual\n\n\nCommand", "2.22\nl/ha\n\n2.00\nl/ha\n\n\n\n2.00\nl/ha\n\n2.00\nl/ha"))
        tableList.add(TableData("2.","PE","Pendimethalin 30EC\n\nDiclosulum 84WDG\n","Stamp, Panida\n\nStrongarm","3.25\nl/ha\n\n26\ng/ha"))
        tableList.add(TableData("3.","POE (10-12 DAS)","Chlorimuron ethyl\n\nImazethapyr 10EC \n\nQuizalofoprthyl 50EC","Cloben, Curin\n\nPersuit\n\n\nTerga Super","36\ng/ha\n\n1.00\nl/ha\n\n1.00\nl/ha"))
        tableList.add(TableData("4.","POE (15-20 DAS)","Quizalofo ptefuryl 4.14EC\n\nFenoxaprop Pethyl 9EC","Rengo\n\n\nWhip Super","1.00\nl/ha\n\n1.00\nl/ha"))
        return tableList
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                @Suppress("DEPRECATION")
                onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}