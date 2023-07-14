import React, { useState } from 'react';



const InputPrint = () => {
    
    const [inputText, setInputText] = useState('')

    const [content, setContent] = useState('위 텍스트 필드에 값을 입력하신 후 버튼을 누르면 이곳에 출력됩니다.')

    const changeContent = () => {
        setContent(inputText);
        setInputText('');
    }

    return(
        <>
            <input type='text' onChange={(e) => setInputText(e.target.value)}></input>
            <button onClick={changeContent}>보내기</button>
            <div className='content'>
                <h2>{content}</h2>
            </div>
        </>
    );
    
};
    

export default InputPrint;