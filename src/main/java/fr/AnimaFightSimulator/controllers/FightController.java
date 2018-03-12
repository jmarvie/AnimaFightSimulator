package fr.AnimaFightSimulator.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.json.JSONArray;
import org.json.JSONObject;
import org.omnifaces.util.Ajax;

import fr.AnimaFightSimulator.beans.Fighter;
import fr.AnimaFightSimulator.utils.LoadingContent;

@ManagedBean(name = "fightController")
@ApplicationScoped
public class FightController {

	@Inject
	private PCFighterController pcFighterController;

	@Inject
	private NPCFighterController npcFighterController;

	private int atq;

	private int def;

	private int dmg;

	private int ip;

	private int score = 0;

	private boolean isInFight = false;

	private boolean isFightNotReady = true;

	private boolean initRollsDisabled = true;

	private List<Fighter> listTotal = new ArrayList<>();

	public void preRenderView() {
		
		for (Fighter fighter : pcFighterController.getPCfighters()) {
			if (!listTotal.contains(fighter)) {
				listTotal.add(fighter);
			}
		}
		for (Fighter fighter : npcFighterController.getNPCfighters()) {
			if (!listTotal.contains(fighter)) {
				listTotal.add(fighter);
			}
		}
		Ajax.updateAll();
	}

	public String startNewRound() {
		return "formFight";
	}

	public String goBackToFightAdmin() {
		return "fightAdmin";
	}

	public String searchResult() throws IOException {
		LoadingContent lc = new LoadingContent();
		isInFight = true;
		List<JSONObject> list = lc.getJsonFromString();
		for (JSONObject obj : list) {
			if (atq - def < 0) {
			} else {
				if ((atq - def) >= Integer.parseInt(obj.get("minLimit").toString())
						&& (atq - def) <= Integer.parseInt(obj.get("maxLimit").toString())) {
					if (ip == Integer.parseInt(obj.get("ipScore").toString())) {
						score = dmg * Integer.parseInt(obj.get("score").toString()) / 100;
					}
				}
			}
		}
		System.out.println(score);
		return "fightAdmin";
	}

	public int getAtq() {
		return atq;
	}

	public void setAtq(int atq) {
		this.atq = atq;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public int getIp() {
		return ip;
	}

	public void setIp(int ip) {
		this.ip = ip;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isInFight() {
		return isInFight;
	}

	public void setInFight(boolean isInFight) {
		this.isInFight = isInFight;
	}

	public boolean isFightNotReady() {
		return isFightNotReady;
	}

	public void setFightNotReady(boolean isFightNotReady) {
		this.isFightNotReady = isFightNotReady;
	}

	public boolean isInitRollsDisabled() {
		return initRollsDisabled;
	}

	public void setInitRollsDisabled(boolean initRollsDisabled) {
		this.initRollsDisabled = initRollsDisabled;
	}

	public List<Fighter> getListTotal() {
		return listTotal;
	}

	public void setListTotal(List<Fighter> listTotal) {
		this.listTotal = listTotal;
	}

}
