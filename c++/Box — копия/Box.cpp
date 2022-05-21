#include "BoxX.h"

using namespace std;
using namespace BoxBox;


box::box() {
    value = 0;
    length = 0;
    width = 0;
    height = 0;
    weight = 0;
}

box::box (int m_value, int m_length, int m_width, int m_height, double m_weight) {
    if (m_value < 0 || m_length < 0 || m_width < 0 || m_height < 0 || m_weight < 0) {
        throw new std::exception ();
    }
    value = m_value;
    length = m_length;
    width = m_width;
    height = m_height;
    weight = m_weight;
}

int BoxBox::sum_value_of_boxes (box* box, int size) {
    int sum = 0;
    for(int i = 0; i < size ; i++) {
        sum += box[i].getValue();
    }
    return sum;
}

bool BoxBox::checking_boxes(box* box, int size, int timet) {
    int sum = 0;
    for(int i = 0; i < size; i++){
        sum += box[i].getLength() + box[i].getWidth() + box[i].getHeight();
    }
    if(sum <= timet)  {
        return false;
    }
    return true;
}

double BoxBox::max_value_of_box(box* box, int size, int maxV) {
    double max_value = 1;

    for(int i = 0; i < size; i++){
        if (box[i].getLength() * box[i].getWidth() * box[i].getHeight() <= maxV && box[i].getWeight() > max_value) {
            max_value = box[i].getWeight();
        }
    }
    return max_value;
}

bool BoxBox::checking_very_big_thing_of_boxes (box* box,int size) {
    bool check = true;
    for(int i = 0; i < size - 1; i++){
        for(int j = i + 1; j < size; j++) {
            if ( !((box[i].getLength() < box[j].getLength() && box[i].getWidth() < box[j].getWidth() && box[i].getHeight() < box[j].getHeight()) ||
                   (box[i].getLength() < box[j].getLength() && box[i].getWidth() < box[j].getWidth() && box[i].getHeight() < box[j].getHeight()))) {
                check = false;
                break;
            } else {
                continue;
            }
        }
    }
    return check;
}

bool BoxBox::eguals_of_boxes (box* box, int size ) {
    bool check = true;
    for (int i = 0; i < size - 1; i++) {
        for(int j = i + 1; j < size; j++) {
            if ( box[i].getLength() != box[j].getLength() || box[i].getWidth() != box[j].getWidth() || box[i].getHeight() != box[j].getHeight()) {
                check = false;
            }
        }
    }
    return check;
}
