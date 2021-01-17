package org.lah.AnimalBreeding.domain;

/**
 * 种猪档案类
 */
public class SelectResultSow{

    private String AnimalNumber;        //动物编号
    private Integer PigAge;           //行为编码
    private String HealthCondition;   //行为开始时间
    private String LifeCondition;     //行为结束时间
    private String Fertility; //行为描述
    private String BreedingHistory;       //处理方案
    private String IfBreedSelectObserved;     //处理结果
    private String IfBreedSelect;     //处理结果

    public SelectResultSow() {
        super();
    }

    public String getAnimalNumber() {
        return AnimalNumber;
    }

    public void setAnimalNumber(String animalNumber) {
        AnimalNumber = animalNumber;
    }

    public Integer getPigAge() {
        return PigAge;
    }

    public void setPigAge(Integer pigAge) {
        PigAge = pigAge;
    }

    public String getHealthCondition() {
        return HealthCondition;
    }

    public void setHealthCondition(String healthCondition) {
        HealthCondition = healthCondition;
    }

    public String getLifeCondition() {
        return LifeCondition;
    }

    public void setLifeCondition(String lifeCondition) {
        LifeCondition = lifeCondition;
    }

    public String getFertility() {
        return Fertility;
    }

    public void setFertility(String fertility) {
        Fertility = fertility;
    }

    public String getBreedingHistory() {
        return BreedingHistory;
    }

    public void setBreedingHistory(String breedingHistory) {
        BreedingHistory = breedingHistory;
    }

    public String getIfBreedSelectObserved() {
        return IfBreedSelectObserved;
    }

    public void setIfBreedSelectObserved(String ifBreedSelectObserved) {
        IfBreedSelectObserved = ifBreedSelectObserved;
    }

    public String getIfBreedSelect() {
        return IfBreedSelect;
    }

    public void setIfBreedSelect(String ifBreedSelect) {
        IfBreedSelect = ifBreedSelect;
    }

    @Override
    public String toString() {
        return "SowRecord{" +
                "AnimalNumber='" + AnimalNumber + '\'' +
                ", PigAge=" + PigAge +
                ", HealthCondition='" + HealthCondition + '\'' +
                ", LifeCondition='" + LifeCondition + '\'' +
                ", Fertility='" + Fertility + '\'' +
                ", BreedingHistory='" + BreedingHistory + '\'' +
                ", IfBreedSelectObserved='" + IfBreedSelectObserved + '\'' +
                ", IfBreedSelect='" + IfBreedSelect + '\'' +
                '}';
    }
}
