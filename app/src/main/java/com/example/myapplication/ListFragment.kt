package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment: Fragment() {
    lateinit var recyclerView: RecyclerView
    var listData: ArrayList<Contacts> = dataList()
    lateinit var myAdapter: ContactAdapter
    lateinit var addContact: ImageButton
    private lateinit var onClickItem: OnClickItem
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.content_main, container, false)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.onClickItem = activity as OnClickItem
        addContact = view.findViewById<ImageButton>(R.id.addContact)
        recyclerView = view.findViewById(R.id.recyclerView)
        //listData = dataList()
        myAdapter = ContactAdapter(listData, view.context)
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(
            view.context,
            LinearLayoutManager.VERTICAL,
            false
        )
        this.addContact.setOnClickListener{
            onClickItem.ButtonClicked()
        }
        this.myAdapter.setOnClickListener(
            object :
                ContactAdapter.OnClickListener {
                override fun onClick(position: Int, model: Contacts) {
                    onClickItem.ItemClicked(model)
                }
            }
        )
    }


    fun UpdateContent(item: Contacts) {
        this.listData.add(item)
        this.myAdapter.notifyItemInserted(listData.size -1 )
    }
    fun dataList() : ArrayList<Contacts>{
        var list: ArrayList<Contacts> = ArrayList<Contacts>()
        list.add(Contacts("Josefina Lehner", "0123456", "josefina.l@gmail.com", "0912345678"))
        list.add(Contacts("Stuart Vandervort II", "9876543", "stuart.v@gmail.com", "0987654321"))
        list.add(Contacts("Maddision Russel ", "1122334", "maddision.r@gmail.com", "0909090909"))
        list.add(Contacts("Halley Morar II", "4455667", "hally.m@gmail.com", "0876543210"))
        list.add(Contacts("Karelle Simonis", "7788990", "karelle.s@gmail.com", "0912345678"))
        list.add(Contacts("Hannah Welch Davis", "3344556", "hannah.w@gmail.com", "0923456789"))
        list.add(Contacts("Fanni Frammi", "6677889", "fanni.f@gmail.com", "0911111111"))
        list.add(Contacts("Elfrieda Wisozk", "1122334", "elfrieda.w@gmail.com", "0944444444"))
        list.add(Contacts("Olivia White", "5566778", "olivia.w@gmail.com", "0966666666"))
        list.add(Contacts("William Lee", "8899001", "william.l@gmail.com", "0988888888"))
        return list
    }
}