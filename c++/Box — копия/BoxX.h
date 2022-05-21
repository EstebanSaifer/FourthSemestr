#ifndef BOX_BOXX_H
#define BOX_BOXX_H

#include <iostream>

namespace BoxBox {
    class box {
    private:
        int value;
        int length;
        int width;
        int height;
        double weight;
    public:
        box();
        box(int m_value, int m_length, int m_width, int m_height, double m_weight);

        void setValue(int m_value) {
            value = m_value;
        }

        int getValue() const {
            return value;
        }

        void setLength(int m_length) {
            length = m_length;
        }

        int getLength() const {
            return length;
        }

        void setWidth(int m_width) {
            width = m_width;
        }

        int getWidth() const {
            return width;
        }

        void setHeight(int m_height) {
            height = m_height;
        }

        int getHeight() const {
            return height;
        }

        void setWeight(double m_weight) {
            weight = m_weight;
        }

        double getWeight() const {
            return weight;
        }
        bool operator == (const box &box2) {
            return (this->length == box2.length && this->height == box2.height && this->value == box2.value && this->weight == box2.weight && this->width == box2.width);
        }

        bool operator != (const box &box2){
            return !(this->length == box2.length && this->height == box2.height && this->value == box2.value && this->weight == box2.weight && this->width == box2.width);
        }

        friend std::ostream& operator << (std::ostream &out, const box& box){
            return out << "Box: {" << box.getValue() << ", " << box.getLength() << ", " << box.getWidth() << ", " << box.getHeight() << ", " << box.getWeight() << "}";
        }

        friend std::istream& operator >> (std::istream &in, box& box){
            in >> box.value >> box.length >> box.width >> box.height >> box.weight;
            if (box.value < 0 || box.length < 0 || box.width < 0 || box.height < 0 || box.weight < 0) {
                throw new std::exception ();
            }
            return in;
        }
    };
    int sum_value_of_boxes (box*, int);
    bool checking_boxes(box*, int, int);
    double max_value_of_box(box*, int, int);
    bool checking_very_big_thing_of_boxes (box*, int);
    bool eguals_of_boxes (box*, int);
}
#endif //BOX_BOXX_H