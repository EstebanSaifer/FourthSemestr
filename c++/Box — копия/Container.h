#ifndef BOX_CONTAINER_H
#define BOX_CONTAINER_H

#include "BoxX.h"
#include <vector>

namespace BoxBox {
    class Container {
        private:
        int length;
        int width;
        int height;
        double maxWeight;
        std::vector<box> boxes;

        public:
        Container();
        Container(int n_length, int n_width, int n_height, double n_max_weight);

        int getLength() const{
            return length;
        }

        int getWidth() const {
            return width;
        }

        int getHeight() const {
            return height;
        }

        double getMaxWeight() const {
            return maxWeight;
        }

        int size() const;

        box operator[] (int i){
            return boxes.at(i);
        }

        int count_of_boxes();
        double sum_of_weight();
        int sum_of_value();
        box get_box(int) const ;
        void add_box(box&);

        void add_box_with_i(box& box, int i) {
            if ((sum_of_weight() + box.getWeight()) <= maxWeight) {
                boxes.push_back(box);
            }
            if (i < size()) {
                auto n = boxes.begin() + i;
                boxes.insert(n, box);
            }
        }

        void delete_box(int i){
            if(i < size()){
                auto n = boxes.begin() + i;
                boxes.erase(n);
            }
        }

        friend std::ostream& operator<< (std::ostream &out, const Container& container){
            out << "Container: {" << container.getLength() << ", " << container.getWidth() << ", " << container.getHeight() << ", " << container.getMaxWeight() << std::endl;
            for(int i = 0; i < container.size(); i++) {
                out << "    " << container.get_box(i);
            }
            out << "}";
            return out;
        }

        friend std::istream& operator>> (std::istream &in, Container& container){
            in >> container.length >> container.width >> container.height >> container.maxWeight;
            if (container.length < 0 || container.width < 0 || container.height < 0 || container.maxWeight < 0) {
                throw std::exception ();
            }
            return in;
        }
    };
}
#endif //BOX_CONTAINER_H
