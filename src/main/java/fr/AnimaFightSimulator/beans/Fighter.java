package fr.AnimaFightSimulator.beans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean(name = "fighter")
public class Fighter implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private int nbActions;
	
	private int initScore;
	
	private int nbHitPoints;
	
	private boolean playableCharacter;
	
	private boolean canCounterAttack;
	
	public Fighter() {
		super();
	}
	
	
	public Fighter(String name) {
		super();
		this.name = name;
	}

	public Fighter(String name, boolean playableCharacter) {
		super();
		this.name = name;
		this.playableCharacter = playableCharacter;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNbActions() {
		return nbActions;
	}


	public void setNbActions(int nbActions) {
		this.nbActions = nbActions;
	}




	public int getInitScore() {
		return initScore;
	}


	public void setInitScore(int initScore) {
		this.initScore = initScore;
	}


	public boolean isPlayableCharacter() {
		return playableCharacter;
	}


	public void setPlayableCharacter(boolean playableCharacter) {
		this.playableCharacter = playableCharacter;
	}


	public boolean isCanCounterAttack() {
		return canCounterAttack;
	}


	public void setCanCounterAttack(boolean canCounterAttack) {
		this.canCounterAttack = canCounterAttack;
	}


	public int getNbHitPoints() {
		return nbHitPoints;
	}


	public void setNbHitPoints(int nbHitPoints) {
		this.nbHitPoints = nbHitPoints;
	}

}
