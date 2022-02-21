package Car;

public class Engine {
        //model, power, displacement and efficiency
        private String model;
        private int power;
        //optional
        private int displacement;
        private String efficiency;
        //1. начин -> model, power
        //2. начин -> model, power,displacement
        //3.начин -> model, power, efficiency
        //4. начин -> model, power, displacement, efficiency

        public Engine (String model, int power) {
            this.model = model;
            this.power = power;
            this.displacement = 0;
            this.efficiency = "n/a";

        }

        public Engine (String model, int power, int displacement) {
            this(model, power);
            this.displacement = displacement;
            this.efficiency = "n/a";
        }

        public Engine (String model, int power, String efficiency) {
            this(model, power);
            this.efficiency = efficiency;
            this.displacement = 0;
        }

        public Engine (String model, int power, int displacement, String efficiency) {
            this(model, power);
            this.displacement = displacement;
            this.efficiency = efficiency;
        }

        public String getModel() {
            return this.model;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Power: " + this.power + "\n");
            if(this.displacement == 0) {
                stringBuilder.append("Displacement: n/a" + "\n");
            } else {
                stringBuilder.append("Displacement: " + this.displacement + "\n");
            }
            stringBuilder.append("Efficiency: " + this.efficiency);
            return stringBuilder.toString();
        }
    }