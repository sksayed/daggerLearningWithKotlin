package com.example.daggerlearning.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.example.daggerlearning.databinding.FragmentListBinding

class ListFragment : BaseFragment() {

    private var dummyButton: Button? = null

    private var fullscreenContent: View? = null
    private var fullscreenContentControls: View? = null
    private var _binding: FragmentListBinding? = null

    private val lifecycleOwner : LifecycleOwner = viewLifecycleOwner

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG ,"On CreateView Called " )
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG ,"On ViewCreated  Called " )


    }

    override fun onResume() {
        super.onResume()
       Log.d(TAG ,"On Resume Called " )


    }

    override fun onPause() {
        super.onPause()
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        Log.d(TAG ,"On Pause Called " )

    }

    override fun onDestroy() {
        super.onDestroy()
        dummyButton = null
        fullscreenContent = null
        fullscreenContentControls = null
        Log.d(TAG ,"On Destroy Called " )
    }





    companion object {
        /**
         * Whether or not the system UI should be auto-hidden after
         * [AUTO_HIDE_DELAY_MILLIS] milliseconds.
         */
        private const val AUTO_HIDE = true

        /**
         * If [AUTO_HIDE] is set, the number of milliseconds to wait after
         * user interaction before hiding the system UI.
         */
        private const val AUTO_HIDE_DELAY_MILLIS = 3000

        /**
         * Some older devices needs a small delay between UI widget updates
         * and a change of the status and navigation bar.
         */
        private const val UI_ANIMATION_DELAY = 300

        private const val TAG = "ListFragment"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d(TAG ,"On DestroyView Called " )
    }
}