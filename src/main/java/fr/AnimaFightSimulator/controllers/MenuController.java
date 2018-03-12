package fr.AnimaFightSimulator.controllers;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.omnifaces.util.Ajax;

import fr.AnimaFightSimulator.beans.Fighter;

@ManagedBean(name = "menuController")
@ApplicationScoped
public class MenuController {

	private boolean isInitRollsDisabled;

	private PCFighterController fighterController = new PCFighterController();

	public boolean windowFighterInfoVisible = false;
	
	public void preRenderView() {
		if (fighterController.getPCfighters().size()>1)
		{
			windowFighterInfoVisible = true;
		}
	}

	public String createPCFighters() {
		return "formCreationPCFighters";
	}
	
	public String createNPCFighters() {
		return "formCreationNPCFighters";
	}

	public String rollInitScores() {
		return "initForm";
	}

	public String startFight() {
		return "fightAdmin";
	}

	public String goBackToIndex() {
		return "index";
	}

	public boolean isInitRollsDisabled() {
		return isInitRollsDisabled;
	}

	public void setInitRollsDisabled(boolean isInitRollsDisabled) {
		this.isInitRollsDisabled = isInitRollsDisabled;
	}

	public boolean isWindowFighterInfoVisible() {
		return windowFighterInfoVisible;
	}

	public void setWindowFighterInfoVisible(boolean windowFighterInfoVisible) {
		this.windowFighterInfoVisible = windowFighterInfoVisible;
	}

}
