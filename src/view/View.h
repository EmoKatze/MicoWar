/*
 * View.h
 *
 *  Created on: 04.06.2019
 *      Author: student
 */

#ifndef SRC_VIEW_VIEW_H_
#define SRC_VIEW_VIEW_H_

#include <src/model/Tile.h>


class View
{
public:
    View(Tile[][]);
    virtual ~View();

    Tile **vboard;


};

View::View(Tile **board){
    vboard = board;
}

#endif /* SRC_VIEW_VIEW_H_ */
