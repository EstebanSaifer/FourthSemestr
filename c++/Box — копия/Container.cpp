#include "vector"
#include "Container.h"

using namespace BoxBox;
using namespace std;

Container::Container() {
    int length = 0;
    int width = 0;
    int height = 0;
    double maxWeight = 0;
}

Container::Container(int n_length, int n_width, int n_height, double n_max_weight) {
    if (n_length < 0 || n_width < 0 || n_height < 0 || n_max_weight < 0) throw std::exception ();
    length = n_length;
    width = n_width;
    height = n_height;
    maxWeight = n_max_weight;
}

int Container::count_of_boxes() {
    int count = 0;
    for(int i = 0; i < boxes.size(); i++) {
        count++;
    }
    return count;
}

int Container::size() const {
    return boxes.size();
}

double Container::sum_of_weight () {
    double sum = 0;
    for(int i = 0; i < boxes.size(); i++) {
        sum += boxes.at(i).getWeight();
    }
    return sum;
}

int Container::sum_of_value () {
    int sum = 0;
    for(int i = 0; i < boxes.size(); i++) {
        sum += boxes.at(i).getValue();
    }
    return sum;
}

box Container::get_box (int i) const {
    return boxes.at(i);
}


void Container::add_box(box& box) {
    if ((sum_of_weight() + box.getWeight()) <= maxWeight) {
        boxes.push_back(box);
    } else {
        throw invalid_argument("total weight > max weight");
    }

    // В класс Container добавьте метод — оператор [ ], который позволяет получить/изменить
    //коробку по индексу.
}
