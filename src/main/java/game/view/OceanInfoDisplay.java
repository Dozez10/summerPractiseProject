package game.view;

import game.model.entity.Ocean;

public class OceanInfoDisplay {
        private Ocean ocean;
        public OceanInfoDisplay(Ocean ocean){
            this.ocean = ocean;
        }

    public void display() {
        for (int i = 0; i < ocean.getRowsNum(); i++) {
            ocean.getCellTable().get(i).forEach(el -> System.out.print(el.getDefImage()));
            System.out.println();
        }
        System.out.println();
    }
    public static String javaFxTextAreaShow(Ocean ocean){
            StringBuilder stringBuilder  = new StringBuilder();
        for (int i = 0; i < ocean.getRowsNum(); i++) {

            ocean.getCellTable().get(i).forEach(el -> stringBuilder.append(el.getDefImage()));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
