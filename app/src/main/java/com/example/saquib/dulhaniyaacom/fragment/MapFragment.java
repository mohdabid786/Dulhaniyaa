//package com.example.saquib.dulhaniyaacom.fragment;
//
//import android.Manifest;
//import android.content.Context;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.os.Bundle;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.view.KeyEvent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.inputmethod.EditorInfo;
//import android.view.inputmethod.InputMethodManager;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.saquib.dulhaniyaacom.R;
//import com.example.saquib.dulhaniyaacom.activities.MainActivity;
//import com.example.saquib.dulhaniyaacom.bean.CommonResponse;
//import com.example.saquib.dulhaniyaacom.database.SharedPreferenceWriter;
//import com.example.saquib.dulhaniyaacom.retrofit.ApiClient;
//import com.example.saquib.dulhaniyaacom.retrofit.ApiInterface;
//import com.example.saquib.dulhaniyaacom.retrofit.MyDialog;
//import com.example.saquib.dulhaniyaacom.util.GPSTracker;
//import com.example.saquib.dulhaniyaacom.util.SharedPreferenceKey;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.LatLngBounds;
//import com.google.android.gms.maps.model.Marker;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//
//public class MapFragment extends Fragment implements OnMapReadyCallback, View.OnClickListener, GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerClickListener {
//    View view;
//    private GoogleMap mMap;
//    MarkerOptions markerOptions = new MarkerOptions();
//    ArrayList<LatLng> marker_list = new ArrayList<>();
//    LatLngBounds.Builder builder = new LatLngBounds.Builder();
//    ImageView map_drawer;
//    RecyclerView recyclerview_onmap;
//    EditText search_edittext;
//    ArrayList<SearchTypeResponse> searchTypeResponseArrayList;
//    // ArrayList<HashMap<String,HashMap<String,String>>> hashMapArrayList;
//    ArrayList<HashMap<String, String>> hashMapArrayList;
//    //when we have to add something then we make object through new.in adapter we only declare list not make object because in adapter data allready comes from anywhere
//    ArrayList<RestaurantResponse> restaurantResponseArrayList = new ArrayList<>();
//
//    private LatLng Noida63Hblock = new LatLng(28.628454, 77.376945);
//    private LatLng Noida63Gblock = new LatLng(28.6161, 77.3906);
//    private LatLng Noida63A = new LatLng(28.535517, 77.391029);
//    private LatLng Noida63b = new LatLng(28.628454, 77.376945);
//    private LatLng noida63some = new LatLng(28.621, 77.3812);
//    private LatLng noida = new LatLng(28.6266412, 77.3848031);
//    String restaurantId = "";
//    ArrayList<HomeResponse> homeResponseArrayList = new ArrayList<>();
//    private ViewGroup infoWindow;
//    private MapWrapperLayout frameMap;
//
//    ImageView iv_fav_img;
//    TextView tv_fav_rname;
//    TextView tv_fav_cousin;
//    TextView tv_review;
//    Double latitude;
//    Double longitude;
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//
//        if (view != null) {
//
//            return view;
//        }
//
//
//        view = inflater.inflate(R.layout.fragment_map, container, false);
//        recyclerview_onmap = (RecyclerView) view.findViewById(R.id.recyclerview_onmap);
//        search_edittext = (EditText) view.findViewById(R.id.search_edittext);
////when we have to send all model data on any key to any activity/fragment,then use serializable
//        homeResponseArrayList = (ArrayList<HomeResponse>) getArguments().getSerializable("homeResponseList");
////        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
////
////        recyclerview_onmap.setLayoutManager(linearLayoutManager);
//
//
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
//        recyclerview_onmap.setLayoutManager(mLayoutManager);
//
//        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
//                .findFragmentById(R.id.mapFragment);
//        mapFragment.getMapAsync(this);
//
//        map_drawer = (ImageView) view.findViewById(R.id.map_drawer);
//        map_drawer.setOnClickListener(this);
//
//        if (homeResponseArrayList != null) {
//            for (HomeResponse homeResponse : homeResponseArrayList) {
//                marker_list.add(new LatLng(Double.parseDouble(homeResponse.getLatitude()), Double.parseDouble(homeResponse.getLongitude())));
//                restaurantId = restaurantId + homeResponse.getId() + ",";
//            }
//        }
//
//        search_edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                    // Check if no view has focus:
//
//                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//
//                    if (!search_edittext.getText().toString().trim().equals(""))
//                        callsearchTypeApi(); //Do whatever you intend to do when user click on search button in keyboard.
//                    return true;
//                }
//
//                return false;
//            }
//
//        });
//
//        search_edittext.addTextChangedListener(textWatcher);
//        //this.infoWindow = (ViewGroup)g().inflate(R.layout.item_window_info, null);
//        frameMap = (MapWrapperLayout) view.findViewById(R.id.frame_map);
//        this.infoWindow = (ViewGroup) getActivity().getLayoutInflater().inflate(R.layout.map_window, null);
//        iv_fav_img = (ImageView) infoWindow.findViewById(R.id.iv_fav_img);
//        tv_fav_rname = (TextView) infoWindow.findViewById(R.id.tv_fav_rname);
//        tv_fav_cousin = (TextView) infoWindow.findViewById(R.id.tv_fav_cousin);
//        tv_review = (TextView) infoWindow.findViewById(R.id.tv_review);
//        return view;
//    }
//
//    public TextWatcher textWatcher = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            if (count == 0) {
//                //Put your code here.
//                //Runs when delete/backspace pressed on soft key (tested on htc m8)
//                //You can use EditText.getText().length() to make if statements here
//                if (search_edittext.getText().toString().trim().length() == 0) {
//                    recyclerview_onmap.setVisibility(View.GONE);
//                }
//            }
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//        }
//    };
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        if (ActivityCompat.checkSelfPermission(MainActivity.instance, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.instance, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(MainActivity.instance, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);
//            return;
//        }
//        // markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurant_location));
//        //mMap.setOnMarkerClickListener(markerOptions);
//        mMap.setOnInfoWindowClickListener(this);
//
//      /*  for (LatLng latLng : marker_list) {
//
//            markerOptions.position(latLng);
//
//            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//            mMap.addMarker(markerOptions);
//
//            int width = getResources().getDisplayMetrics().widthPixels;
//            int height = getResources().getDisplayMetrics().heightPixels;
//            int padding = (int) (width * 0.12);
//
//            builder.include(latLng);
//            LatLngBounds bounds = builder.build();
//            // mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding));
//            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 10);
//            mMap.animateCamera(cameraUpdate);
//
//
//        }*/
//        for (int i = 0; i < homeResponseArrayList.size(); i++) {
//            String lati = homeResponseArrayList.get(i).getLatitude();
//            String longi = homeResponseArrayList.get(i).getLatitude();
//            latitude = Double.parseDouble(lati);
//            longitude = Double.parseDouble(longi);
//            setMarker(latitude, longitude, i);
//
//
//        }
//        googleMap.setMyLocationEnabled(true);
//        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//
//        if (googleMap != null) {
//            googleMap.setOnInfoWindowClickListener(this);
//            frameMap.init(googleMap, getPixelsFromDp(MainActivity.instance, 20));
//
//            googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
//                @Override
//                public View getInfoWindow(Marker marker) {
//                    tv_fav_rname.setText(homeResponseArrayList.get(Integer.parseInt(marker.getTitle())).getRest_name());
//                    tv_fav_cousin.setText(homeResponseArrayList.get(Integer.parseInt(marker.getTitle())).getRest_type());
//                    Picasso.with(MainActivity.instance).load(homeResponseArrayList.get(Integer.parseInt(marker.getTitle())).getImage_url()).into(iv_fav_img);
//                    // txtTeepsCount.setText(spotsList.get(Integer.parseInt(marker.getTitle())).getTeeps_count() + "");
//                    // txtTeepListCount.setText(spotsList.get(Integer.parseInt(marker.getTitle())).getTeeplist_count() + "");
//                    frameMap.setMarkerWithInfoWindow(marker, infoWindow);
//                    return infoWindow;
//                }
//
//                @Override
//                public View getInfoContents(Marker marker) {
//                    return null;
//                }
//            });
//        }
//
//    }
//
//    public static int getPixelsFromDp(Context context, float dp) {
//        final float scale = context.getResources().getDisplayMetrics().density;
//        return (int) (dp * scale + 0.5f);
//    }
//
//    @Override
//    public void onClick(View view) {
//
//        switch (view.getId()) {
//
//            case R.id.map_drawer:
//
//                if (restaurantId.endsWith(",")) {
//                    restaurantId = restaurantId.substring(0, restaurantId.length() - 1);
//                }
//                //getFragmentManager().beginTransaction().replace(R.id.content, new MapDrawerActivity()).commit();
//                Intent intent = new Intent(getActivity(), MapDrawerActivity.class);
//                intent.putExtra("restaurantId", restaurantId);
//                startActivity(intent);
//
//                break;
//
//        }
//
//    }
//
//    public void callsearchDetailApi(String resId, String type, String city) {
//        GPSTracker gpsTracker = new GPSTracker(getActivity(), getActivity());
//        String latitude = "", longitude = "";
//        try {
//            double lat = gpsTracker.getLatitude();
//            double lan = gpsTracker.getLongitude();
//            latitude = String.valueOf(lat);
//            longitude = String.valueOf(lan);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        MyDialog.getInstance(getActivity()).showDialog();
//        Retrofit retrofit = ApiClient.getClient();
//        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
//        Call<CommonResponse> call = apiInterface.getsearchDetailResult(SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.token), resId, type, latitude, longitude, city);
//
//        call.enqueue(new Callback<CommonResponse>() {
//            @Override
//            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
//                MyDialog.getInstance(getActivity()).hideDialog();
//                if (response.isSuccessful()) {
//                    if (response.body().getStatus().equals("SUCCESS")) {
//                        restaurantResponseArrayList = (ArrayList<RestaurantResponse>) response.body().getSearchDetail();
//                        marker_list.clear();
//                        LatLng latLng;
//                        if (restaurantResponseArrayList != null) {
//                            for (int i = 0; i < restaurantResponseArrayList.size(); i++) {
//                                latLng = new LatLng(Double.parseDouble(restaurantResponseArrayList.get(i).getLatitude()), Double.parseDouble(restaurantResponseArrayList.get(i).getLongitude()));
//                                marker_list.add(latLng);
//                            }
//                        }
//                        onMapReady(mMap);
//                        //Toast.makeText(getActivity(), "success", Toast.LENGTH_LONG).show();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CommonResponse> call, Throwable t) {
//                MyDialog.getInstance(getActivity()).hideDialog();
//            }
//        });
//    }
//
//    @Override
//    public void onInfoWindowClick(Marker marker) {
//        //if (marker.getTitle() != null) {
//        Intent intent = new Intent(getActivity(), Description.class);
//        intent.putExtra("image", homeResponseArrayList.get(Integer.parseInt(marker.getTitle())).getImage_url());
//        intent.putExtra("rest_name", homeResponseArrayList.get(Integer.parseInt(marker.getTitle())).getRest_name());
//        intent.putExtra("rest_type", homeResponseArrayList.get(Integer.parseInt(marker.getTitle())).getRest_type());
//        intent.putExtra("rest_description", homeResponseArrayList.get(Integer.parseInt(marker.getTitle())).getRest_description());
//        intent.putExtra("lat", homeResponseArrayList.get(Integer.parseInt(marker.getTitle())).getLatitude());
//        intent.putExtra("log", homeResponseArrayList.get(Integer.parseInt(marker.getTitle())).getLongitude());
//        intent.putExtra("restaurant_id", homeResponseArrayList.get(Integer.parseInt(marker.getTitle())).getId());
//        startActivity(intent);
//        //  intent.putExtra("rest_name", homeResponseArrayList.get(0).getRest_name());
//        // intent.putExtra("rest_type", homeResponseArrayList.get(0).getRest_type());
//
//
//    }
//
//    @Override
//    public boolean onMarkerClick(Marker marker) {
//        return false;
//    }
//
//    protected void setMarker(Double latitude, Double longitude, int id) {
//        LatLng latLng1 = new LatLng(latitude, longitude);
//        Marker marker = mMap.addMarker(new MarkerOptions().position(latLng1).title(id + "").icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurant_location)));
//        String t = marker.getTitle();
//        marker.hideInfoWindow();
//        mMap.getUiSettings().setZoomControlsEnabled(true);
//        mMap.getUiSettings().setCompassEnabled(true);
//        mMap.getUiSettings().setAllGesturesEnabled(true);
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 12.0f));
//    }
//
//    private void callsearchTypeApi() {
//        search_edittext.clearFocus();
//        MyDialog.getInstance(getActivity()).showDialog();
//        Retrofit retrofit = ApiClient.getClient();
//        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
//        Call<CommonResponse> call = apiInterface.getsearchTypeResult(SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.token), search_edittext.getText().toString());
//
//        call.enqueue(new Callback<CommonResponse>() {
//            @Override
//            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
//                MyDialog.getInstance(getActivity()).hideDialog();
//                if (response.isSuccessful()) {
//                    if (response.body().getStatus().equals("SUCCESS")) {
//                        hashMapArrayList = new ArrayList<HashMap<String, String>>();
//                        recyclerview_onmap.setVisibility(View.VISIBLE);
//                        searchTypeResponseArrayList = (ArrayList<SearchTypeResponse>) response.body().getSearchType();
//                        if (searchTypeResponseArrayList.get(0).getLocation() != null) {
//                            for (int i = 0; i < searchTypeResponseArrayList.get(0).getLocation().size(); i++) {
//                                HashMap hashMap = new HashMap();
//                                hashMap.put("city", searchTypeResponseArrayList.get(0).getLocation().get(i).getCity());
//                                hashMap.put("restaurant_id", searchTypeResponseArrayList.get(0).getLocation().get(i).getRestaurent_id());
//                                hashMap.put("type", searchTypeResponseArrayList.get(0).getLocation().get(i).getType());
//                                hashMap.put("cousine", "");
//                                hashMap.put("check", "location");
//                                hashMapArrayList.add(hashMap);
//                            }
//                        }
//                        if (searchTypeResponseArrayList.get(0).getCousine() != null) {
//                            if (!searchTypeResponseArrayList.get(0).getCousine().equals("")) {
//                                HashMap hashMap = new HashMap();
//                                hashMap.put("city", "");
//                                hashMap.put("restaurant_id", "");
//                                hashMap.put("type", "");
//                                hashMap.put("cousine", searchTypeResponseArrayList.get(0).getCousine());
//                                hashMap.put("check", "cousine");
//                                hashMapArrayList.add(hashMap);
//                            }
//                        }
//                        if (searchTypeResponseArrayList.get(0).getRestaurent() != null) {
//                            for (int i = 0; i < searchTypeResponseArrayList.get(0).getRestaurent().size(); i++) {
//                                HashMap hashMap = new HashMap();
//                                hashMap.put("city", searchTypeResponseArrayList.get(0).getRestaurent().get(i).getRest_name());
//                                hashMap.put("restaurant_id", searchTypeResponseArrayList.get(0).getRestaurent().get(i).getId());
//                                hashMap.put("type", searchTypeResponseArrayList.get(0).getRestaurent().get(i).getType());
//                                hashMap.put("cousine", "");
//                                hashMap.put("check", "restaurant");
//                                hashMap.put("image", searchTypeResponseArrayList.get(0).getRestaurent().get(i).getImage_url());
//                                hashMap.put("rest_name", searchTypeResponseArrayList.get(0).getRestaurent().get(i).getRest_name());
//                                hashMap.put("rest_type", searchTypeResponseArrayList.get(0).getRestaurent().get(i).getRest_type());
//                                hashMap.put("rest_description", searchTypeResponseArrayList.get(0).getRestaurent().get(i).getRest_description());
//                                hashMap.put("lat", searchTypeResponseArrayList.get(0).getRestaurent().get(i).getLatitude());
//                                hashMap.put("log", searchTypeResponseArrayList.get(0).getRestaurent().get(i).getLongitude());
//                                restaurantId = restaurantId + searchTypeResponseArrayList.get(0).getRestaurent().get(i).getId() + ",";
//                                hashMapArrayList.add(hashMap);
//                            }
//                        }
//
//                        //Toast.makeText(getActivity(), "success", Toast.LENGTH_LONG).show();
//                        SearchAdapter searchAdapter = new SearchAdapter(getActivity(), hashMapArrayList, search_edittext.getText().toString(), search_edittext, recyclerview_onmap, MapFragment.this);
//                        recyclerview_onmap.setAdapter(searchAdapter);
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CommonResponse> call, Throwable t) {
//                MyDialog.getInstance(getActivity()).hideDialog();
//            }
//        });
//    }
//}
