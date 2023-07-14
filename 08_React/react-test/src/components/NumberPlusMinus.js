import React, { useState } from 'react';

const NumberPlusMinus = () => {

    const [count, setCount] = useState(0);

    return (
        <div className='countWrapper'>
            <button className='minus' onClick={() => setCount(count - 1)}>-</button>
            {count}
            <button className='plus' onClick={() => setCount(count + 1)}>+</button>
        </div>
    );
};

export default NumberPlusMinus;