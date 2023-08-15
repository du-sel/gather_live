package DTO;

import java.util.ArrayList;

public class Recruit {

	private int board_id;
	private int post_id;
	
	private String title;
	private String duration;
	private String specDuration;
	private String already;
	private String otherinst;
	
	private String loca_g1;
	private String loca_g2;
	private String loca_g3;
	
	private String pref_datetime;
	private String free;
	
	private String created;
	private int created_by;
	private String views;
	
	private ArrayList<Recruit_inst> instList;

	
	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getSpecDuration() {
		return specDuration;
	}

	public void setSpecDuration(String specDuration) {
		this.specDuration = specDuration;
	}

	public String getAlready() {
		return already;
	}

	public void setAlready(String already) {
		this.already = already;
	}

	public String getOtherinst() {
		return otherinst;
	}

	public void setOtherinst(String otherinst) {
		this.otherinst = otherinst;
	}

	public String getLoca_g1() {
		return loca_g1;
	}

	public void setLoca_g1(String loca_g1) {
		this.loca_g1 = loca_g1;
	}

	public String getLoca_g2() {
		return loca_g2;
	}

	public void setLoca_g2(String loca_g2) {
		this.loca_g2 = loca_g2;
	}

	public String getLoca_g3() {
		return loca_g3;
	}

	public void setLoca_g3(String loca_g3) {
		this.loca_g3 = loca_g3;
	}

	public String getPref_datetime() {
		return pref_datetime;
	}

	public void setPref_datetime(String pref_datetime) {
		this.pref_datetime = pref_datetime;
	}

	public String getFree() {
		return free;
	}

	public void setFree(String free) {
		this.free = free;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
	}

	public ArrayList<Recruit_inst> getInstList() {
		return instList;
	}

	public void setInstList(ArrayList<Recruit_inst> instList) {
		this.instList = instList;
	}
	
}
