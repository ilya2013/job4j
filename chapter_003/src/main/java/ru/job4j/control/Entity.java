package ru.job4j.control;

import java.util.Objects;

public class Entity {

        /**
         * Имя.
         */
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Entity(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Entity)) {
                return false;
            }
            Entity that = (Entity) o;
            return Objects.equals(getName(), that.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName());
        }

        @Override
        public String toString() {
            return "Entity{"
                    + "name='"
                    + name
                    + '\''
                    + '}';
        }
    }
