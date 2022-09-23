#include <iostream>
#include "queue.h"


template<typename T>
Quant::Queue<T>::Queue() {
    //pass
}

template<typename T>
void Quant::Queue<T>::push_front(const T &entry) {

}

template<typename T>
void Quant::Queue<T>::push_back(const T &entry) {

}

template<typename T>
T Quant::Queue<T>::front() {
    return nullptr;
}

template<typename T>
T Quant::Queue<T>::back() {
    return nullptr;
}

template<typename T>
bool Quant::Queue<T>::empty() {
    return false;
}

template<typename T>
int Quant::Queue<T>::size() {
    return 0;
}

template<typename T>
void Quant::Queue<T>::emplace() {

}

template<typename T>
T Quant::Queue<T>::pop() {
    return nullptr;
}

template<typename T>
void Quant::Queue<T>::swap() {

}

template<typename T>
void Quant::Queue<T>::dequeue() {

}

template<typename T>
void Quant::Queue<T>::enqueue() {

}


int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}