package com.example.homework_23.ui

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_23.databinding.ActivityMainBinding
import kotlin.getValue

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var adapter: ProductsAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupRecyclerView()
        setupObservers()
        setupListeners()

    }

    private fun setupListeners() {

        binding.buttonAdd.setOnClickListener {
            val productName = binding.inputProduct.text.toString().trim()
            viewModel.addProduct(productName)
            binding.inputProduct.text.clear()
            hideKeyboard()
            binding.inputProduct.clearFocus()
        }

        binding.inputProduct.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                binding.buttonAdd.performClick()
                true
            } else {
                false
            }
        }

        binding.floatingAddButton.setOnClickListener {
            binding.inputProduct.requestFocus()
            showKeyboard()
        }
    }

    private fun setupObservers() {
        viewModel.products.observe(this) { products ->
            adapter.updateList(products)
        }
    }

    private fun setupRecyclerView() {
        adapter = ProductsAdapter(viewModel)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun showKeyboard() {
        WindowCompat.getInsetsController(window, binding.inputProduct)
            .show(WindowInsetsCompat.Type.ime())
    }

    private fun hideKeyboard() {
        WindowCompat.getInsetsController(window, binding.buttonAdd)
            .hide(WindowInsetsCompat.Type.ime())
    }
}