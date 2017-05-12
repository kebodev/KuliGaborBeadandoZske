/*
Kuli Gábor beadandó feladat
 */

package com.kebodev.kulig;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class ListRecyclerViewAdapter extends RecyclerView.Adapter<ListRecyclerViewAdapter.ViewHolder> {

  private final List<Matches> myMatches;

  public ListRecyclerViewAdapter(List<Matches> matches) {
    myMatches = matches;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.mMatches = myMatches.get(position);
    holder.mHomeTeam.setText(myMatches.get(position).getHomeTeam());
    holder.mAwayTeam.setText(myMatches.get(position).getAwayTeam());
    holder.dateMatch.setText(myMatches.get(position).getDateOfGame());
  }

  @Override
  public int getItemCount() {
    return myMatches.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public Matches mMatches;
    public final TextView mHomeTeam;
    public final TextView mAwayTeam;
    public final TextView dateMatch;

    public ViewHolder(View view) {
      super(view);
      mView = view;
      mHomeTeam = (TextView) view.findViewById(R.id.home_team);
      mAwayTeam = (TextView) view.findViewById(R.id.away_team);
      dateMatch = (TextView) view.findViewById(R.id.dateMatch);
    }

    @Override
    public String toString() {
      return super.toString() + " '" + mHomeTeam.getText() + "'";
    }
  }
}
