package com.example.jaspreet.blog;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArticleListAdapter articleListAdapter;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);
        articleListAdapter = new ArticleListAdapter();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setAdapter(articleListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching articles");
        progressDialog.show();
        ApiManager.getApiInterface().getArticles()
                .enqueue(new Callback<List<Aricle>>() {
                    @Override
                    public void onResponse(Call<List<Aricle>> call, Response<List<Aricle>> response) {
                        progressDialog.dismiss();
                        if (response.isSuccessful()) {
                            articleListAdapter.setData(response.body());
                        } else {
                            //alert
                            Toast.makeText(ArticleListActivity.this,"Failed",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Aricle>> call, Throwable t) {
                    }
                });
    }

    public class ArticleListAdapter extends RecyclerView.Adapter<ArticleItemViewHolder> {

       List<Aricle> articleList = new ArrayList<>();

        @Override
        public ArticleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //inflate the view  i.e layout_article.xml
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_article,parent, false);
            return new ArticleItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ArticleItemViewHolder holder, final int position) {
            //setting of  the data
           holder.articleName.setText(articleList.get(position).getHeading());
           holder.cardView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Toast.makeText(ArticleListActivity.this,"Article CLicked!" +articleList.get(position).getHeading(),Toast.LENGTH_LONG)
                           .show();
               }
           });
            }

        @Override
        public int getItemCount() {
            return articleList.size();
        }

        public void setData(List<Aricle> data) {
            this.articleList = data;
            this.notifyDataSetChanged();
        }
    }
}
