#include "iostream"
#include "BoxX.h"
#include "Container.h"

using namespace std;
using namespace BoxBox;

int test_sum_value_of_boxes();
bool test_checking_boxes();
int test_max_value_of_box();
int test_checking_very_big_thing_of_boxes();
int test_eguals_of_boxes();

int test_for_container();



int main(){
    test_sum_value_of_boxes();
    test_checking_boxes();
    test_max_value_of_box();
    test_checking_very_big_thing_of_boxes();
    test_eguals_of_boxes();

    test_for_container();
}

int test_sum_value_of_boxes() {
    int size = 5;
    box box1(5, 5, 5, 10, 2);
    box box2(2, 1, 3, 17, 10.3);
    box box3(5, 6, 5, 16, 5);
    box box4(1, 5, 5, 5, 3);
    box box5 = box(3, 1, 4, 10, 10);

    box *boxes = new box[size];
    boxes[0] = box1;
    boxes[1] = box2;
    boxes[2] = box3;
    boxes[3] = box4;
    boxes[4] = box5;

    int summa = sum_value_of_boxes(boxes, size);
    cout << "sum_value_of_boxes: " << summa << endl ;
    return summa;
}

bool test_checking_boxes() {
    int size = 5;
    box box1(5, 5, 5, 10, 2);
    box box2(2, 1, 3, 17, 10);
    box box3(5, 6, 5, 16, 5);
    box box4(1, 5, 5, 5, 3);
    box box5 = box(3, 1, 4, 10, 10);

    box *boxes = new box[size];
    boxes[0] = box1;
    boxes[1] = box2;
    boxes[2] = box3;
    boxes[3] = box4;
    boxes[4] = box5;

    bool check = checking_boxes(boxes,size, 9999999);
    if(check == 0) cout << "Sum of value,length and height is less than set value" << endl;
    if(check == 1) cout << "Sum of value,length and height is more than set value" << endl;
    return check;
}

int test_max_value_of_box() {
    int size = 5;
    int maxV = 25;
    box box1(1, 5, 5, 1, 2);
    box box2(10, 5, 3, 17, 10.5);
    box box3(5, 10, 5, 16, 6);
    box box4(10, 5, 5, 5, 3.4);
    box box5 = box(3, 10, 5, 10, 10);

    box *boxes = new box[size];
    boxes[0] = box1;
    boxes[1] = box2;
    boxes[2] = box3;
    boxes[3] = box4;
    boxes[4] = box5;

    int max = max_value_of_box(boxes,size,maxV);
    cout << max << endl;
    return max;
}

int test_checking_very_big_thing_of_boxes() {
    int size = 5;
    box box1(1, 1, 1, 1, 1);
    box box2(2, 2, 2, 2, 2);
    box box3(3, 3, 3, 3, 3);
    box box4(5, 5, 5, 1, 5);
    box box5 = box(10, 10, 10, 10, 10);

    box *boxes = new box[size];
    boxes[4] = box1;
    boxes[3] = box2;
    boxes[2] = box3;
    boxes[1] = box4;
    boxes[0] = box5;
    bool check = checking_very_big_thing_of_boxes(boxes, size);
    cout << "checking_very_big_thing_of_boxes " << check << endl;
    return 0;
}

int test_eguals_of_boxes() {
    int size = 3;
    box box1(1, 1, 1, 1, 1);
    box box2 = box(1, 1, 1, 1, 1);
    box box3 = box(1, 1, 1, 1, 1);

    box *boxes = new box[size];
    boxes[0] = box1;
    boxes[1] = box2;
    boxes[2] = box3;

    bool result = eguals_of_boxes(boxes, size);
    cout << "eguals_of_boxes: " << result << endl;
    return 0;
}

int test_for_container(){
    Container container (10,10,10,10);

    box box1(4, 1, 1, 1, 3);
    box box2(7, 1, 1, 1, 4);

    container.add_box(box1);
    container.add_box(box2);

    cout << "size: " << container.size() << endl;
    cout << "count_of_boxes: " << container.count_of_boxes() << endl;
    cout << "sum_of_value: " << container.sum_of_value() << endl;

    try{
        box box10(1, 1, 1, 3, 1);
        box box20(2, 2, 1, 4, 1);
        box box30(2, 2, 3, 5, 1);
        container.add_box(box10);
        container.add_box(box20);
        container.add_box(box30);
    }catch(invalid_argument& e){
        cout << e.what() << endl;
    }

    box *boxes = new box[2];
    boxes[0] = box1;
    boxes[1] = box2;

    box box3(1, 1, 1, 1, 4);

    cout << container[0] << endl;
    container.add_box_with_i(box3,0);
    cout << container[0] << endl;

    cout<< boxes[0] << endl;
    boxes[0].setValue(3);
    cout << "boxes " << boxes[0].getValue() << endl;

    cout << container << endl;

    cin >> box1 ;
    cin >> box2;

    cout << endl << box1 << endl ;
    cout << box2 << endl;

    cin >> container ;
    cout << endl << container << endl;
    return 0;
}
