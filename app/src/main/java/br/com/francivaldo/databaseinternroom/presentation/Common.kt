package br.com.francivaldo.databaseinternroom.presentation

import br.com.francivaldo.databaseinternroom.presentation.viewmodel.MainViewModel

class Common {
    companion object {
        private var mViewModel:MainViewModel? = null
        fun getViewModel():MainViewModel{
            return mViewModel!!
        }
        fun setViewModel(viewModel: MainViewModel){
            mViewModel = viewModel
        }
    }
}