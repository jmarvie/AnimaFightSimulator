package fr.AnimaFightSimulator.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Ajax;

import fr.AnimaFightSimulator.beans.Fighter;

@ManagedBean(name = "pcFighterController")
@ApplicationScoped
public class PCFighterController {

	private Fighter fighter = new Fighter();

	public List<Fighter> PCfighters;

	private int initScore;

	public void preRenderView() {
		if (PCfighters == null) {
			PCfighters = new ArrayList<Fighter>();
		}
	}
	
	public void validatePCFighters() {
		FacesContext.getCurrentInstance().getAttributes().put("PCFighters", PCfighters);
	}

	public void addPCFighter() {
		PCfighters.add(fighter);
		fighter = new Fighter();
		Ajax.updateAll();
	}

	public void sortPCFightersByInitScore() {
		Collections.sort(PCfighters, new Comparator<Fighter>() {
			public int compare(Fighter o1, Fighter o2) {
				return Integer.signum(o2.getInitScore() - o1.getInitScore());
			}
		});
		for (Fighter fighter : PCfighters) {
			System.out.println(fighter.getName());
			System.out.println(fighter.getInitScore());
		}
	}

	public void removeAllPCFighters() {
		PCfighters.clear();
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

	public List<Fighter> getPCfighters() {
		return PCfighters;
	}

	public void setPCfighters(List<Fighter> pCfighters) {
		PCfighters = pCfighters;
	}

}
