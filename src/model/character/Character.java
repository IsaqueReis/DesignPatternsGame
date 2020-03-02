package model.character;

import model.designpatterns.state.*;
import model.designpatterns.strategy.*;
import model.designpatterns.chainofresponsability.*;

public abstract class Character{

	private Attack_Behavior attack;
	private Jump_Behavior jump;
	private Run_Behavior run;
	private LifeState lifeState;
	private Shield shields;
	private double hp;
	private String name;

	public Character(Attack_Behavior attack, Jump_Behavior jump, Run_Behavior run, String name){
		setAttack(attack);
		setJump(jump);
		setRun(run);
		setName(name);

		//setting up normal life state of character
		setHP(100.0);
		setLifeState(new Strong(this));
	}
	
	public void setAttack(Attack_Behavior attack){
		this.attack = attack;
	}

	public Attack_Behavior getAttack()
	{
		return this.attack;
	}

	public void setJump(Jump_Behavior jump){
		this.jump = jump;
	}
	public void setRun(Run_Behavior run){
		this.run = run;
	}

	public void Attack_Action(){
		attack.Attack();
	}

	public void Run_Action(){
		run.Run();
	}

	public void Jump_Action(){
		jump.Jump();
	}

	public void setLifeState(LifeState lf)
	{
		this.lifeState = lf;
	}

	public LifeState getLifeState()
	{
		return this.lifeState;
	}
		
	public Shield getShield() 
	{
		return this.shields;
	}

	public void setHP(double amount)
	{
		this.hp = amount;
	}

	public double getHP()
	{
		return this.hp;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void insertShield(Shield s)
	{
		if(this.shields == null)
		{
			this.shields = s;
			this.shields.setSucessor(null);
		}
		else
		{
			Shield last = this.shields;
			while(last.getSucessor() != null)
				last = last.getSucessor(); //transverse shields

			last.setSucessor(s);
			last.getSucessor().setSucessor(null);
		}
	}

	public int getNumOfShields()
	{
		int count = 0;

		if(this.shields == null)
		{
			return 0;
		}
		else
		{
			Shield last = this.shields;
			while(last.getSucessor() != null)
			{
				last = last.getSucessor();
				count++;
			}

			return count + 1;
		}
	}

	public boolean haveShields()
	{
		if(this.getShield() == null)
			return false;
		return true;
	}

}