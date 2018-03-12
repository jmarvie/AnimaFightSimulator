package fr.AnimaFightSimulator.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.omnifaces.util.Ajax;

import fr.AnimaFightSimulator.beans.Fighter;

@ManagedBean(name = "npcFighterController")
@ApplicationScoped
public class NPCFighterController {

	private Fighter fighter = new Fighter();

	public List<Fighter> NPCfighters = new ArrayList<Fighter>();

	private int initScore;

	private boolean formFightersVisible = false;

	public void preRenderView() {
		if (NPCfighters == null) {
			NPCfighters = new ArrayList<Fighter>();
		}
	}

	public void addNewNPCFighter() {
		formFightersVisible = true;
		Ajax.updateAll();
	}

	public void addNPCFighter() {
		NPCfighters.add(fighter);
		fighter = new Fighter();
		formFightersVisible = false;
		Ajax.updateAll();
	}

	public void removeAllNPCFighters() {
		NPCfighters.clear();
	}

	public Fighter getFighter() {
		return fighter;
	}

	public void setFighter(Fighter fighter) {
		this.fighter = fighter;
	}

	public int getInitScore() {
		return initScore;
	}

	public void setInitScore(int initScore) {
		this.initScore = initScore;
	}

	public void setInitScoreForFighter(Fighter fighter) {
		fighter.setInitScore(initScore);
	}

	public boolean isFormFightersVisible() {
		return formFightersVisible;
	}

	public void setFormFightersVisible(boolean formFightersVisible) {
		this.formFightersVisible = formFightersVisible;
	}

	public List<Fighter> getNPCfighters() {
		return NPCfighters;
	}

	public void setNPCfighters(List<Fighter> nPCfighters) {
		NPCfighters = nPCfighters;
	}

}
