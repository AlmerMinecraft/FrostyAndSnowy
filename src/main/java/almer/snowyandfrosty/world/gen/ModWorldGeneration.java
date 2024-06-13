package almer.snowyandfrosty.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModTreeGeneration.generateTrees();
        ModPeatGeneration.generatePeat();
    }
}
