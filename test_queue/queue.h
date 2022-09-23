//
// Created by Justin K on 9/23/2022.
//

#ifndef TEST_QUEUE_QUEUE_H
#define TEST_QUEUE_QUEUE_H
#define DEFAULT_SIZE 1024

namespace Quant{
    template <typename T>
    class Queue{
        private:
            const T *array[DEFAULT_SIZE];
            T *head;
            T *tail;
        public:
            Queue();
            void push_back(const T& entry);
            void push_front(const T& entry);
            T front();
            T back();
            bool empty();
            int size();
            void emplace();
            T pop();
            void swap();
            void dequeue();
            void enqueue();

    };


}



#endif //TEST_QUEUE_QUEUE_H
